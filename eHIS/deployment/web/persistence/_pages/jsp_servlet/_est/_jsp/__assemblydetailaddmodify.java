package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.AssemblyDetailBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __assemblydetailaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/AssemblyDetailAddModify.jsp", 1720525521425L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script> \n\t\t <script language=\'javascript\' src=\'../../eST/js/AssemblyDetail.js\'></script>\n\t\t <script language=\'javascript\' src=\'../../eST/js/StCommon.js\'></script>\n\t\t <script language=\"JavaScript\" src=\"../../eMM/js/MmCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <script>\n function checkPositiveNumber(obj) {  \n   var  obj_value\t\t\t=\t\"\";\n\t\tobj_value\t\t\t=\tobj.value;    // checks for positive number greater than zero\n\tvar obj_length\t\t\t=\tobj_value.length;\n\n    var zero\t\t\t\t=\tobj_value.charAt(0);\n   if(zero==\"0\")\n\t{\n   \t\tobj_value\t\t\t=\tobj_value.charAt(obj_value.length-1)\n\t\tdocument.AddModify_Frame.Seqence_No.value = obj_value;\n\t}\n \tif(obj.value == \"\"){\n\t\treturn true;\n\t}\n\tif(obj != null ){\n\n\t\tif(obj_value > 0){\n\t\t\treturn true;\n\t\t}else{\n\t\t\t//alert(\"only allow numbers\");\n\t\t\tobj.value= \"\"\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t}else{\n\t\treturn true;\n\t}\n\t\n}\n\n </script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onMouseDown=\"CodeArrest()\">\n\t\t<form name=\'AddModify_Frame\' id=\'AddModify_Frame\' method=\'post\' >\n\t\t<center>\n\t\t\t<table border=0 cellpadding=1 cellspacing=0 width=\'100%\' align=center>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4>&nbsp;</td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t\t<td   class=\"label\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\" width=\'5%\' nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\n\t\t\t\t<td   class=\'fields\' >&nbsp;<input type=\'text\' size=70  maxlength=60 name=\'child_item_code_desc\' id=\'child_item_code_desc\'   value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ><input type=button name=\'searchitem\' id=\'searchitem\' value=\"?\" class=\'Button\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" onClick=\"callItemSearchScreen(child_item_code_desc,document.forms[0]);\" >&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t\t\t\n\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t<td  id=\"stock_uom\" class=\"QUERYDATA\" nowrap> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td colspan=7>&nbsp;</td>\n\t\t\t\t</tr><tr>\n\t\t\t\t\n\t\t\t\t<td  class=\"label\"  nowrap>&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\"label\">\n\t\t\t\t<select name=\"Manufactur\" id=\"Manufactur\">\n\t            <OPTION value=\"\"selected>&nbsp;---";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="--- &nbsp;</OPTION>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t   <OPTION value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"selected >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</OPTION>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"selected>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</OPTION>\n\t\t\t   ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</SELECT>\n\t\t        </TD>\n\t\t\t\t<td   colspan = 10 class=\"label\"></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=0 cellpadding=1 cellspacing=0 width=\'100%\' align=center>\n\t\t\t<tr>\n\t\t\t\t<td  width=\'10%\' class=\"label\">&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<!-- \t\t\n\t\t\t* @Name - Priya\n\t\t\t* @Date - 12/02/2010\n\t\t\t* @Inc# - 19272\n\t\t\t* @Desc - No.of Decimals is passed to isValidNumber function and in onblur  checkdoubleformat is called and maxlength is changed to 12.\t\t\t\n\t\t-->\n\t\t\t\t<td class=\"fields\"  width=\"15%\">&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'text\'  onKeyPress=\"return isValidNumber(this,event,7,";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =");\"  onBlur=\"checkDoubleFormat(this);\"  name=\"component_qty\" class=\"NUMBER\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=12 maxlength=12>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n\t\t\t\t\n\t\t\t\t<td  width=\"10%\" class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td  class=\'fields\'   width=\"23%\">&nbsp;\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t  <select name=\'mfg_uom\' id=\'mfg_uom\' onBlur=\"getUOMConvertionFactor();\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\t\n\t\t\t\n\t\t\t  <select name=\'mfg_uom\' id=\'mfg_uom\' onBlur=\"getUOMConvertionFactor();\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\n\t\t\t   \n               <td  width=\"10%\" class=\"label\" nowrap >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n               <td class=\"fields\"  nowrap >&nbsp;<input type=\'text\'  name=\"Seqence_No\" id=\"Seqence_No\"  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=5 maxlength=2  onKeyPress=\"return CheckForSequence(event);\" onblur=\"checkSeqNo(this);return checkPositiveNumber(this);\"  >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' >\n\t\t\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;\n\t\t\t\t<b id=\"td_sale_stk_uom_conv_rule\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</b></td>\n\t\t\t\t<td  class=\"QUERYDATA\" ><b id=\"td_sale_stk_uom_conv\" STYLE=\"visibility:hidden\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b></td>\n\t\t\t\n\t\t\t\t</tr>\n\n\n\n\t\t\t<tr>\n\t\t\t\t<td   class=\"label\" >&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t<!--<td  class=\'fields\'>&nbsp;&nbsp;&nbsp;<input type=\'checkbox\' name=\'component\' id=\'component\' checked  value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ></td> -->\n\t\t\t\t\n\t\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;&nbsp;<input type=\'checkbox\' name=\'component\' id=\'component\'  value=\"\"   ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ></td> \n\t\t\t\t\n\t\t\t\t<td   class=\"label\" align=\"left\" nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t<td  class=\'fields\' >&nbsp;<input type=\'checkbox\' name=\'mandatory\' id=\'mandatory\'   value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">\n\t\t\t\t</td> \n\t\t\t\t<td   class=\"label\"  nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t    <!--<td  class=\'fields\' nowrap>&nbsp;<input type=\'checkbox\' name=\'PrintOnlabel\' id=\'PrintOnlabel\'   value=\"Y\" checked > -->\n\t\t\t\t<td  class=\'fields\' colspan=\"3\">&nbsp;<input type=\'checkbox\' name=\'PrintOnlabel\' id=\'PrintOnlabel\'   value=\"\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" > \n\t\t\t\t\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<input type=button name=\'add\' id=\'add\' value=\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \" class=\'Button\'  onClick=\"displayResult(";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =");\">\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=reset name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' onClick=\"cancelData()\"class=\'Button\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'6\' >&nbsp;</td>\n\t\t\t\t<td colspan=\'6\' >&nbsp;</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t</table>\n\t\t<input type=hidden name =\"child_item_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\'\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\'\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\'hidden\' name=\'uom_code\' id=\'uom_code\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\'hidden\' name=\'SEQ_NO\' id=\'SEQ_NO\'\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\'hidden\' name=\'MFG_DESC\' id=\'MFG_DESC\'\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\'hidden\' name=\'assembly_size\' id=\'assembly_size\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\'hidden\' name=\'allow_deci_yn\' id=\'allow_deci_yn\'\t\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t    <input type=\'hidden\' name=\'no_deci\' id=\'no_deci\'\t\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t<!-- \t\t\n\t\t* @Name - Priya\n\t\t* @Date - 12/02/2010\n\t\t* @Inc# - 19272\n\t\t* @Desc - Code added to accept decimal values dynamically.\t\t\t\n\t\t-->\n\t<input type=\"hidden\"\t\tname=\"dec_allowed_yn\" id=\"dec_allowed_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t</center>\n\t</form>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t<script>\n\t\t\tpopulateMFGUoms();\n\t\t</script>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            java.util.ArrayList AssemblyDtlList= null;synchronized(session){
                AssemblyDtlList=(java.util.ArrayList)pageContext.getAttribute("AssemblyDtlList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AssemblyDtlList==null){
                    AssemblyDtlList=new java.util.ArrayList();
                    pageContext.setAttribute("AssemblyDtlList",AssemblyDtlList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String bean_id								=		"AssemblyDetailBean";
	String bean_name							=		"eST.AssemblyDetailBean";
	String disable								=		"";
	String Manufactur							=		"";
	HashMap hmRecord							=		new HashMap();

	AssemblyDetailBean bean						=		(AssemblyDetailBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear();
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String default_value						=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	ArrayList ManufacturInstructionsList		=		new ArrayList();
    HashMap ManufacturInstructionsMap			=		new HashMap();
	ManufacturInstructionsList					=		bean.ManufacturingInstructions();
	String index								=		bean.checkForNull(request.getParameter("index"),"-1");

	
//	String legend								=		" Add ";
	String legend								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	ArrayList recordSet							=		new ArrayList();
	recordSet									=		AssemblyDtlList;

	
	String mode									=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	String uom_code								=		"";
	String SEQ_NO								=		"";
	String PRINT_ON_LABEL_YN					=		"";
	String INSTRN_CODE							=		"";
	String INSTRN_CODE1							=		"";
	String instrn_code							=		"";
	String instrn_text							=		"";
	String MFG_DESC								=		"";
	String stk_uom								=		"";
	String allow_deci_yn                        =       "";
	int no_deci                                 =       bean.getNoOfDecimals();
	String item_code                            =    "";
	String printlabel                           =    "Y";
	String component_yn                         =     "Y";
	String cheked			                    =	  "";
	String cheked1			                    =	  "";
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){

	disable										=		"disabled";
	recordSet									=		bean.getDataModifyList();
	
	}

	if(!index.equals("-1")){
		//legend								=		" Modify ";
	    legend									=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		hmRecord								=		(HashMap)	recordSet.get(Integer.parseInt(index));

		bean.setChild_item_code(bean.checkForNull((String)hmRecord.get("CHILD_ITEM_CODE")));
		bean.setShort_desc(bean.checkForNull((String)hmRecord.get("SHORT_DESC")));
		bean.setComponent_qty(bean.checkForNull((String)hmRecord.get("COMPONENT_QTY")));
		bean.setComponent(bean.checkForNull((String)hmRecord.get("COMPONENT")));
		bean.setMfg_uom(bean.checkForNull((String)hmRecord.get("MFG_UOM_CODE")));
		bean.setMandatory(bean.checkForNull((String)hmRecord.get("MANDATORY")));
		bean.setStock_uom(bean.checkForNull((String)hmRecord.get("STOCK_UOM")));
		bean.setConv_factor(bean.checkForNull((String)hmRecord.get("CONV_FACTOR")));
		bean.setTd_sale_stk_uom_conv_rule(bean.checkForNull((String)hmRecord.get("TD_SALE_STK_UOM_CONV_RULE")));
		
		//30/11/2012
		 component_yn  =  bean.checkForNull(bean.getComponent());
		if(bean.checkForNull(((String)hmRecord.get("PRINTONLABEL"))).equals(""))
		 printlabel =  bean.checkForNull((String)hmRecord.get("PRINT_ON_LABEL_YN"));
		else
	     printlabel =  bean.checkForNull((String)hmRecord.get("PRINTONLABEL"));
	   
		uom_code								=		bean.checkForNull((String)hmRecord.get("UOM_CODE"));
		stk_uom									=		bean.checkForNull((String)hmRecord.get("STOCK_UOM"));
		Manufactur								=		bean.checkForNull((String)hmRecord.get("Manufactur"));
		INSTRN_CODE								=		bean.checkForNull((String)hmRecord.get("INSTRN_CODE"));
		MFG_DESC								=		bean.checkForNull((String)hmRecord.get("MFG_DESC"));
		allow_deci_yn								=		bean.checkForNull((String)hmRecord.get("ALLOW_DECI_YN"));
		item_code = bean.checkForNull((String)bean.getChild_item_code()) ;
		allow_deci_yn        =       bean.getAllowDecimalsYN(bean.getChild_item_code());
            if(allow_deci_yn.equals("N"))
			no_deci              =0;
		
		if(legend.equals("Modify"))
		{
          INSTRN_CODE1							=		Manufactur;
		}

		PRINT_ON_LABEL_YN						=		bean.checkForNull((String)hmRecord.get("PRINT_ON_LABEL_YN"));
		SEQ_NO									=		bean.checkForNull((String)hmRecord.get("SEQ_NO"));
		}
	else
		disable								=		"";
		
		if(printlabel.equals("Y")){
		cheked			=		"checked";
		}
		if(component_yn.equals("Y")){
		cheked1			=		"checked";
		}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean.checkForNull(bean.getShort_desc())));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean.checkForNull(bean.getStock_uom(),"&nbsp;")));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 for(int i=0; i<ManufacturInstructionsList.size(); i++)
				{
					ManufacturInstructionsMap	= (HashMap)ManufacturInstructionsList.get(i);
					instrn_code					= (String)ManufacturInstructionsMap.get("instrn_code");
					instrn_text					= (String)ManufacturInstructionsMap.get("instrn_text");
				
				
				 if((instrn_code.equals(INSTRN_CODE.trim()))&&(mode.equals("2")))
				 {
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(INSTRN_CODE));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(instrn_text));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
			  
				else if((instrn_code.equals(Manufactur.trim()))&&(mode.equals("1")))
				{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Manufactur));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(instrn_text));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
               
		else if((instrn_code.equals(INSTRN_CODE1.trim()))&&(mode.equals("2"))&&(legend.equals("Modify")))
				{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(INSTRN_CODE1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(instrn_text));
            _bw.write(_wl_block20Bytes, _wl_block20);
}


			   else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(instrn_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(instrn_text));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}
			
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.setNumber((String)bean.getComponent_qty(),no_deci)));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

	if(!index.equals("-1")){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.getPur_uom_code_Modify_List(uom_code)));
            _bw.write(_wl_block28Bytes, _wl_block28);

}else{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(default_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(SEQ_NO));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.checkForNull(bean.getTd_sale_stk_uom_conv_rule(),"&nbsp;")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean.checkForNull(bean.getConv_factor(),"&nbsp;")));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( bean.getComponent()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((bean.getComponent()).equals("Y")?"checked":""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cheked1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( bean.getMandatory()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( (bean.getMandatory()).equals("Y")?"checked":""));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(cheked));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(legend));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(bean.getChild_item_code())));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(SEQ_NO));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(MFG_DESC));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(AssemblyDtlList.size()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allow_deci_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getAllowDecimalsYN(item_code)));
            _bw.write(_wl_block57Bytes, _wl_block57);

	if(((AssemblyDtlList.size()>0)||(legend.equals("Modify")))){

            _bw.write(_wl_block58Bytes, _wl_block58);

	}
putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block59Bytes, _wl_block59);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Ingredients.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.MfgInstructions.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.MFGUOM.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SequenceNo.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockConvFactor.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mandatory.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PrintOnlabel.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
