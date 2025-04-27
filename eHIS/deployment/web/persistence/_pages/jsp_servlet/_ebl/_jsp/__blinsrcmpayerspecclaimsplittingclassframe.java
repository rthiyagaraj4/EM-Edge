package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.ClaimSplittingBean;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import eBL.Common.BlRepository;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blinsrcmpayerspecclaimsplittingclassframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLInsRCMPayerSpecClaimSplittingClassFrame.jsp", 1726114655714L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n<html>\r\n<head>\r\n\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/BLInsRCMPayerSpecSupDocConfig.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/BLInsRCMPayerSpecClaimSplitting.js\"></script>\r\n\r\n</head>\r\n\r\n\r\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" >\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n<form  name=\"serviceTableFrm\" id=\'serviceTableFrm\' >\r\n\t<table  border=\'0\' cellpadding=\'1\' cellspacing=\'1\' align=\'center\' width=\'100%\'>\r\n\t\t<tr>\r\n\t\t\t<td class=\'columnheadercenter\' nowrap colspan = 2>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t<tr/>\r\n\t</table>\r\n\t<table  cellpadding=\'10\' cellspacing=\'0\'  align=\"center\" width=\"100%\" name=\"tblService\" id=\"tblService\"  border=\"1\"  >\r\n\t\t\r\n\t\t<thead>\r\n\t\t<TR>\r\n\t\t<td  class=\'columnheader\' width=\"3%\" align=\"center\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\r\n\t\t<td  class=\'columnheader\' width=\"20%\" align=\"center\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" <img src=\'../../eCommon/images/mandatory.gif\'></td>\r\n\t\t<td  class=\'columnheader\' width=\"30%\" align=\"center\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" <img src=\'../../eCommon/images/mandatory.gif\'></td>\r\n\t\t<td  class=\'columnheader\' width=\"20%\" align=\"center\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\r\n\t\t<td  class=\'columnheader\' width=\"3%\" align=\"center\"></td>\r\n\r\n\t\t</TR>\r\n\t\t</thead>\r\n\t\t<tbody>\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\r\n\t\t\r\n\t\t<tr rowvalue=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'fields\' name=\'sNo_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'sNo_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' style=\"text-align:center\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' nowrap style=\"text-align:center\">\r\n\t\t\t\t\t<Select name=\'classType_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'classType_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onchange=\"clearBillingService(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =");\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\r\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' selected>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\t\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t</Select>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' nowrap style=\"text-align:center\">\r\n\t\t\t\t\t<input type=\'text\' id=\'bg_code_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' name=\'bg_code_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=\'20\'  onblur=\'if(this.value!=\"\"){callBGDescCode(2,classType_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =",bg_desc_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",bg_code_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =");validateServiceCode(this); } else{ clearField(bg_desc_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")}\' />\r\n\t\t\t\t\t<input type=\'button\' id=\'bg_but_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' name=\'bg_but_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'?\' onclick=\'callBGDescCode(2,classType_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =");validateServiceCode(this);\'>\r\n\t\t\t\t\t<input type=\'text\' id=\'bg_desc_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' name=\'bg_desc_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'  readonly size=\'40\' onblur=\'if(this.value!=\"\"){ callBGDesc(2,classType_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="); } else{ clearField(bg_code_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =")}\' />\r\n\t\t\t\t\t\r\n\t\t\t\t\t\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'fields\' style=\"text-align:center\">\r\n\t\t\t\t\t<input type=\'text\' name=\'claimSubgroup_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'claimSubgroup_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' size=\'30\' maxlength=\'30\'  onblur=\'if(this.value!=\"\"){claimSubgroupLookup(claimSubgroup_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =",claimSubgroupCode_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =");}else{clearField(claimSubgroupCode_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =");}\' />\r\n\t\t\t\t\t<input type=\'hidden\' name=\'claimSubgroupCode_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'claimSubgroupCode_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'/>\r\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"claimSubgroupBtn_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"claimSubgroupBtn_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\'?\' onClick=\'claimSubgroupLookup(claimSubgroup_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =");\' tabindex=\'2\' />\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' style=\"text-align:center\">\r\n\t\t\t\t<img src=\'../../eCommon/images/MarkError.gif\' name=\"deleteBtn_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  id=\"deleteBtn_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onClick=\'deleteServiceRow(this)\' />\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t</tr>\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\r\n\t\t\r\n\t</table>\r\n\t<br/>\r\n\t<div style=\"width: 100%; text-align: right; padding:5px\">\r\n\t<input type=\'button\' class=\'button\' name=\"add_btn\"   id=\"add_btn\" value=\'Add\' onClick=\"addServiceRow()\" style=\"margin-right: 2px;\" ></\r\n\t</div>\r\n\t<input type=\'hidden\' name=\'locale\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\r\n\t<input type=\'hidden\' name=\'facility_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\r\n\t<input type=\'hidden\' name=\'sName\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'/>\r\n\t<input type=\'hidden\' name=\'payerGroup\' id=\'payerGroup\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\r\n\t<input type=\'hidden\' name=\'payer\' id=\'payer\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\r\n\t<input type=\'hidden\' name=\'mode\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\r\n\t<input type=\'hidden\' name=\'serviceRowCount\' id=\"serviceRowCount\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\r\n\t<input type=\'hidden\' name=\'pageInfo\' id=\'pageInfo\' value=\'docsInfo\'>\r\n\t<input type=\'hidden\' name=\'classTypeDesc\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\r\n    <input type=\'hidden\' name=\'classTypeCode\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\r\n\r\n\r\n    </form>\r\n\r\n</body>\r\n</html>\r\n\r\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
	
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);


		
	 request.setCharacterEncoding("UTF-8"); 
	 String beanId = "bl_ClaimSplittingBean" ;
	 String beanName = "eBL.ClaimSplittingBean";
	 ClaimSplittingBean docBean = (ClaimSplittingBean) getBeanObject(beanId, beanName, request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
			
	String mode = checkForNull(request.getParameter("mode"));
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");

	
	String payerGroup          = checkForNull(request.getParameter("payergroup"));
	String payer               = checkForNull(request.getParameter("payer"));
	String policyType          = checkForNull(request.getParameter("policy"));
	String claimType           = checkForNull(request.getParameter("claimType"));
	System.err.println("dsadsaD---->"+docBean.getClassificationList().size());
	String classifcationName   = checkForNull(request.getParameter("classifcationName"));
	
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	
	
	ClaimSplittingBean fmtDtlsBean = null;
	System.err.println("classifcationName->>>>>>>>>>>>"+classifcationName);
	ArrayList<ClaimSplittingBean> classTypes = new ArrayList<ClaimSplittingBean>();
	System.out.println("IM true "+ docBean.getClassificationList().size());
	if(docBean.getClassificationList().containsKey(classifcationName)){
		System.out.println("IM true "+ docBean.getClassificationList().size());
		classTypes = docBean.getClassificationList().get(classifcationName);
	}
	
	System.err.println("classTypes->>>>>>>>>>>>"+classTypes.size());
	
	
	int sNo=1;
	String classTypeDesc="";
	String classTypeCode="";
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	
	String readonly = "";
	String disabled = "";

	String sql="";
	int tableIndex=1;
	
	String class_list_item_MOHE="N";
	String classTypeSql="";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = null;
		rst = null;
		
		//added by khaled for MOHE-CRF-0166.8
		try
		{
		
			class_list_item_MOHE = (eCommon.Common.CommonBean.isSiteSpecific(con, "BL","RCM_TRANS_FIELDS_MOH"))?"Y":"N";
		} catch(Exception ex) {
			System.err.println("Error in claimsplittingclassfate for getting RCM_TRANS_FIELDS_MOH Connection: "+ex);
			ex.printStackTrace();
		}			
		System.err.println("class_list_item_MOHE:"+class_list_item_MOHE);
		if(class_list_item_MOHE.equals("Y")){
			classTypeSql = BlRepository.getBlKeyValue("PAYER_SPEC_SERV_CLASSIFICATION");
		}else{
			classTypeSql = BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		}
		 
		System.err.println("classsql->>>"+classTypeSql);
		pstmt = con.prepareStatement(classTypeSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		classTypeDesc = "";
		classTypeCode = "";
	if(rst!=null){
		while(rst.next()){
			criteriaMap.put(rst.getString("code"),rst.getString("description"));
			classTypeDesc = classTypeDesc+":::"+rst.getString("description");
			classTypeCode = classTypeCode+":::"+rst.getString("code");
		}	
	}	
	
	
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
				
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con);
				
	}
	
		

	

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		
			ClaimSplittingBean classType=null;
			if(!(classTypes == null || classTypes.isEmpty())){
					
				String checked = "";
			
				for(int i=0;i<classTypes.size();i++){
					
					classType=classTypes.get(i);
					System.err.println(classType.getEpisodeIP());
				
		
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block20Bytes, _wl_block20);

						for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
						if(type.equals(classType.getClassType())){
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(criteriaMap.get(type) ));
            _bw.write(_wl_block23Bytes, _wl_block23);

						}else{
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(criteriaMap.get(type) ));
            _bw.write(_wl_block25Bytes, _wl_block25);
			
						}}
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classType.getBlngServCode()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classType.getBlngServDesc()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classType.getClaimSubgroupDesc()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classType.getClaimSubgroup()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);

			tableIndex++;
			sNo++;
				}
			}
			
		
		
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classifcationName));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(payerGroup));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classTypeDesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classTypeCode));
            _bw.write(_wl_block64Bytes, _wl_block64);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.servClassPerClaimType.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Sno.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CLASS_TYPE.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.billingServicesItems.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.claimSubgroup.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
