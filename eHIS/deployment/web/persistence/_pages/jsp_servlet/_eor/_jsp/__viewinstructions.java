package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import java.sql.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewinstructions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewInstructions.jsp", 1731639462000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" <!-- IN049419 -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\t<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t<style type=\'text/css\'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>\n\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n</head>\n\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<FORM METHOD=POST ACTION=\"\">\n<!--<table cellpadding=3 cellspacing=0 border=0 align=center width=\"100%\" height=\"100%\">--><!--IN64543-->\n<table cellpadding=3 cellspacing=0 border=0 align=center width=\"100%\"><!--IN64543-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<tr>\n\t<td class=label>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=fields><TEXTAREA NAME=\"\" ROWS=\"6\" COLS=\"25\" readonly>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TEXTAREA></td>\n\t<td class=label>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td class=fields><TEXTAREA NAME=\"\" ROWS=\"6\" COLS=\"27\" readonly>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TEXTAREA></td>\n</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n <div class=\"outer-container\" style=\'width:630px;height:435px\'>\n    <div class=\"top-section\" style=\'width:630px;height:200px;overflow:auto\'>\n      <table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' align=\'center\' width=\"100%\">\n     \t<tr>\n\t      <td  class=\'normal\'>\n\t      ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t      </td>\n      \t</tr>\n      \t<tr>\n\t      <td>\n\t      ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t      </td>\n      \t</tr>     \n       </table> \n    </div>\n    <table>\n    <tr><td>&nbsp;</td></tr>\n    <tr>\n    \t<td class=\"button\" colspan=2 align=\'right\'><INPUT TYPE=\"button\"  class=\"button\" align=\'right\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onClick=\'instructionsPrintPreview();\'>\n    </td>\n    </tr>\n    <tr><td>&nbsp;</td></tr>   \n    </table>\n    <div class=\"top-section\" style=\'width:630px;height:200px;overflow:auto\'>\n    <table cellpadding=3 cellspacing=0 border=0 align=center width=\"100%\">\n    <tr>\n\t \t<td  class=normal>\n\t     \t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t \t</td>\n     </tr>\n     <tr>\n\t\t<td> \n\t\t    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  \n\t\t</td>\n      </tr>\n      </table>\n    </div>\n  </div>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<table cellpadding=3 cellspacing=0 border=0 align=center width=\"100%\"><!--IN64543-->\n<!-- IN049419 - Start -->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<tr>\n\t\t\t<td  class=\'LABEL\'>\n\t\t\t\t ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'LABEL\'> \n\t\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'LABEL\'>  \n\t\t\t\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" &nbsp;:\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<a class=\"gridLink\" href=\"javascript:ShowComments(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="...</a>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\t</td></tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n<!-- IN049419 - End -->\n<!--IN030472 Start.-->\n<!--\n<tr><td class=\"button\" colspan=5><INPUT TYPE=\"button\"  class=\"button\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onClick=\'window.close()\'></td></tr>\n-->\n</table><!--IN64543-->\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' align=\'center\' width=\"100%\"><!--IN64543-->\n<tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<td colspan=\'2\' align=\'center\'><INPUT TYPE=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" onClick=\'instructionsPrintPreview();\'></td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n<td colspan=\'2\' align=\'right\'><INPUT TYPE=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onClick=\'toCloseTopShowModal();\'></td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<!--IN030472 End.-->\n<input type=\"hidden\" name=\"instrn_type\" id=\"instrn_type\" value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\n</FORM>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
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

/*
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
15/11/2012		IN030472		Ramesh G	Bru-HIMS-CRF-031[Patient instructions to be printed on demand] 
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order
12/9/2014		IN051103		Karthi L			12/9/2014		Akbar		Amended by Details displayed as Null
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order
16/09/2014		IN051127		Karthi L			16/09/2014		Ramesh			View Audit trail->All the text of entered reason is displayed in same line
18/09/2014		IN051106		Karthi L			18/09/2014		Ramesh			Selected Amend reason is not displaying for recent Amend Audit.
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
---------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	//out.println(catalog_code+"<br>");
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	//String sex =  request.getParameter("sex");
	bean.setLanguageId(localeName);
	String instruction = "";
	String orderId   = request.getParameter("orderId");
 	String order_line_num   = request.getParameter("order_line_num");
 	
	// IN049419 - Start
	String deptData  = "";
 	String bean_id1 = "Or_ViewOrder";
 	String bean_name1 = "eOR.ViewOrder";
 	ViewOrder bean1 = (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
 	bean1.setLanguageId(localeName);
 	String audit_reqd_yn = bean.getOrderFormatAuditTrailYN();
 	String max_seq = request.getParameter("max_seq")==null?"":request.getParameter("max_seq") ;	
 	String field_mnemonic = request.getParameter("field_mnemonic")==null?"":request.getParameter("field_mnemonic");
 	String curr_sequ_num = request.getParameter("curr_sequ_num")==null?"":request.getParameter("curr_sequ_num");
 	String instrn_type = request.getParameter("instrn_type")==null?"":request.getParameter("instrn_type");//IN64543
 	String base_max_sequ_num = "0";
 	String modified_max_sequ = "";
 	int modified_max_sequ_num = 0;
 	//int curr_mod_sequ_num = 0;//commented for checkstyle
 	String max_num = "0";
 	String max_action_seq_num = "";
 	PreparedStatement prepStat = null;
 	ResultSet resultSet = null;
 	Connection con = null;
 	String sql = "";
 	String amend_date = "";
 	String amend_by = "";
 	String amend_rson = "";
 	if(max_seq==null) max_seq="";
 		max_action_seq_num = max_seq;
 	HashMap orderLineMap = null;
 	String	audit_comments_reqd = request.getParameter("audit_comments_reqd")==null?"":request.getParameter("audit_comments_reqd"); // added for IN051122
 	int amendRsonLength = 0; //IN051127
	// IN049419 End.
 	
	//String no_of_days = (String)bean.getPatientNoOfDays( patient_id, orderId) ;
	//if(no_of_days == null) no_of_days = ""; else	no_of_days = no_of_days.trim();

	//out.println(catalog_code +"-");
	//out.println(no_of_days +"-");
	//out.println(sex);

	//instruction = bean.getPatientInstruction(catalog_code.trim(),no_of_days,sex) ;
	// commented for IN049419 - Start
	/*instruction = bean.getPatientInstruction(orderId,order_line_num) ;
	if(instruction == null)	instruction = "";

	String deptData  = "";
	deptData = bean.getDeptdata(orderId,order_line_num) ; */
	// Commented End
	// IN049419 Start
	try{
		if(audit_reqd_yn.equalsIgnoreCase("Y")) {
			base_max_sequ_num = bean1.getOrderLineInstMaxCount(orderId, order_line_num, field_mnemonic);
			
			modified_max_sequ_num = Integer.parseInt(base_max_sequ_num);
			modified_max_sequ_num = modified_max_sequ_num + 1;
			modified_max_sequ = Integer.toString(modified_max_sequ_num);
			if(curr_sequ_num == null || curr_sequ_num.equals("")){
				if(max_action_seq_num.equals(""))
					max_action_seq_num	=  base_max_sequ_num;
				if(max_action_seq_num == null)
					max_action_seq_num = "";
				else 
					max_action_seq_num = max_action_seq_num.trim();
				
				max_num = max_action_seq_num;
	
			}else{
				max_num = curr_sequ_num;
			}
			if(curr_sequ_num.equals("") || modified_max_sequ.equals(curr_sequ_num) ) {
				instruction = bean.getPatientInstruction(orderId,order_line_num) ;
				deptData 	= bean.getDeptdata(orderId,order_line_num) ; 
				//orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, "Instruction", localeName); - IN051106
				//IN051106 - Start
				if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
	 				orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, max_num, field_mnemonic, localeName);
				}
				else {
					orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, curr_sequ_num, field_mnemonic, localeName);
				}
				//IN051106 - End
				if(orderLineMap != null){
					amend_by = (String)orderLineMap.get("ADDED_NAME")==null?"":(String)orderLineMap.get("ADDED_NAME");
					amend_date = (String)orderLineMap.get("ADDED_DATE")==null?"":(String)orderLineMap.get("ADDED_DATE");
					amend_date = com.ehis.util.DateUtils.convertDate(amend_date,"DMYHM","en",localeName);
					amend_rson = (String)orderLineMap.get("AMEND_REASON")==null?"":(String)orderLineMap.get("AMEND_REASON"); //IN051106
				}
			}
			else {
			
				if(max_num != null && max_num != "") { 
					
					con = ConnectionManager.getConnection(); 
					//sql = "SELECT (SELECT practitioner_name FROM am_practitioner_lang WHERE practitioner_id = a.added_by_id AND language_id = ?)ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.ORDER_LINE_FIELD_MNEMONIC in( 'DEPT_INSTRNS',   'PATIENT_INSTRNS')   AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; - Commented for IN051103
					//sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.ORDER_LINE_FIELD_MNEMONIC in( 'DEPT_INSTRNS',   'PATIENT_INSTRNS')   AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; // Modified for IN051103 - Commented for IN051105
					sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=b.MODIFIED_BY_ID), ?, '1') ADDED_NAME, to_char(b.MODIFIED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.ORDER_LINE_FIELD_MNEMONIC in( 'DEPT_INSTRNS',   'PATIENT_INSTRNS')   AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; // Modified for IN051105
					prepStat = con.prepareStatement(sql);
					prepStat.setString(1, localeName);
					prepStat.setString(2, orderId);
					prepStat.setInt(3, Integer.parseInt(max_num));
					prepStat.setInt(4, Integer.parseInt(order_line_num));
					resultSet = prepStat.executeQuery();
					while(resultSet.next()){
						//amend_rson = resultSet.getString("ORDER_AMEND_REASON"); - IN051106
						amend_by = resultSet.getString("ADDED_NAME")==null?"":resultSet.getString("ADDED_NAME");
						amend_date = resultSet.getString("ADDED_DATE")==null?"":resultSet.getString("ADDED_DATE");
						amend_date = com.ehis.util.DateUtils.convertDate(amend_date,"DMYHM","en",localeName);
					}
					
					orderLineMap 	= bean1.getOrderLineInstructions(orderId, order_line_num, max_num, "PATIENT_INSTRNS", localeName);
					if(orderLineMap != null){
						instruction 	= (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
					}	
					orderLineMap 	= bean1.getOrderLineInstructions(orderId, order_line_num, max_num, "DEPT_INSTRNS", localeName);
					if(orderLineMap != null) {
						deptData 		= (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
						amend_rson = (String)orderLineMap.get("AMEND_REASON")==null?"":(String)orderLineMap.get("AMEND_REASON"); //IN051106
					}	
				}
			}
			// IN051127 - Start	
			if(!amend_rson.equals("") && !amend_rson.equals(null)){
				amendRsonLength = amend_rson.length();
			}
			// IN051127 - End
		}
		else {
			instruction = bean.getPatientInstruction(orderId,order_line_num) ;
			deptData 	= bean.getDeptdata(orderId,order_line_num) ; 
	
		}
	}
	catch(Exception ex){
		System.err.println(" 165. ViewInstructions.jsp " + ex.getMessage());
		ex.printStackTrace();
	}
	finally {
		if(resultSet != null) resultSet.close();
		if(prepStat != null) prepStat.close();
		if(con != null) con.close();
	}
	if(instruction == null || instruction.equals("null"))
		instruction = "";
	if(deptData == null || deptData.equals("null"))
		deptData = "";
	// IN049419 - End


            _bw.write(_wl_block11Bytes, _wl_block11);

if("T".equals(instrn_type))//IN64543
{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(instruction));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(deptData));
            _bw.write(_wl_block16Bytes, _wl_block16);

}

            _bw.write(_wl_block17Bytes, _wl_block17);

//IN64543, starts
if("E".equals(instrn_type))
{

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(instruction));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(deptData));
            _bw.write(_wl_block23Bytes, _wl_block23);

}
//IN64543,ends

            _bw.write(_wl_block24Bytes, _wl_block24);
 if(audit_reqd_yn.equalsIgnoreCase("Y")) { 
	if(audit_comments_reqd.equalsIgnoreCase("Y")) { // IN051122
	//ML-MMOH-SCF-1108 start
		String seqStr = "".equals(max_seq)?curr_sequ_num:max_seq;
		int max_seq_int = Integer.parseInt(seqStr);

            _bw.write(_wl_block25Bytes, _wl_block25);
if(max_seq_int>1){ 

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(amend_date ));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(max_seq_int>1){ 

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(amend_by));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(max_seq_int>1){ 

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block32Bytes, _wl_block32);

		//ML-MMOH-SCF-1108 end
		// IN051127 - Start
		if(amendRsonLength > 30) { 
			//IN051106 - Start
			if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
				
				max_num = max_num;
			}
			else {
				max_num = curr_sequ_num;
			}
			modified_max_sequ_num = Integer.parseInt(max_num);
			modified_max_sequ_num = modified_max_sequ_num - 1;
			max_num = Integer.toString(modified_max_sequ_num);
			
			//IN051106 - End
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(max_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(amend_rson.substring(0,29)));
            _bw.write(_wl_block36Bytes, _wl_block36);
 }else {
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(amend_rson ));
            _bw.write(_wl_block30Bytes, _wl_block30);
 } // IN051127 - End
            _bw.write(_wl_block37Bytes, _wl_block37);
 } } //IN051122 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block39Bytes, _wl_block39);

if(!"E".equals(instrn_type))//IN64543
{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")));
            _bw.write(_wl_block41Bytes, _wl_block41);

}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(instrn_type));
            _bw.write(_wl_block45Bytes, _wl_block45);
	
		putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instructions.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Departmental.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.amenddate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.amendby.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.amendreason.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
}
