package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.OperationDtlBean;
import eOT.Common.OTRepository;
import java.util.HashMap;
import java.util.StringTokenizer;
import eOT.OTBillingBean;
import eOT.*;
import eCommon.Common.CommonBean;
import eOR.OrderEntryBillingQueryBean;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __operationstaticdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationStaticDtl.jsp", 1732086616000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n\t<script language=\'javascript\' src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t  \n<link href=\"../../eCommon/html/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\n\t<script language=\'javascript\'>\n\tfunction callUpdateDtl(str)\n\t{\n\t\tvar arr = str.split(\"::\");\n\t\tarr[2] = arr[2].replace(\"%\",\"\'\"); //Apostrophe in Operation Desc\n\t\tparent.frames[0].document.forms[0].durFromFrame.value = arr[4];\n\t\tvar objFrm=document.forms[0];\n\t\tvar remarks=eval(\"objFrm.xx\"+arr[0]+\".value\");\n\t\tvar avg_time=arr[5]==\"ISNULL\"?\"\":arr[5];\n\t\tvar std_durn=arr[6]==\"ISNULL\"?\"\":arr[6];\n\t\t//Added By Gaurav Against ML-MMOH-SCF-2511\n\t\tvar fpp_category = document.forms[0].fppCatFromORDesc.value;\n\t\tif(fpp_category!= \"\") //ML-MMOH-CRF-1939 US005\n\t\t{\n\t\t\t//fpp_order_yn = \"Y\";\n\t\t\tif(fpp_category === \"Simple\") fpp_category=\"S\";\n\t\t\tif(fpp_category === \"Moderate\") fpp_category=\"M\";\n\t\t\tif(fpp_category === \"Complex\") fpp_category=\"C\";\n\t\t\t\n\t\t\tparent.frames[0].setAllValues(arr[0],arr[1],arr[2],arr[3],decodeURIComponent(remarks),arr[4],avg_time,std_durn,arr[7],fpp_category);\n\t\t}else{\n\t\t//Added By Gaurav Against ML-MMOH-SCF-2511\n\t\tparent.frames[0].setAllValues(arr[0],arr[1],arr[2],arr[3],decodeURIComponent(remarks),arr[4],avg_time,std_durn,arr[7],arr[8]);\n\t\t}//Added By Gaurav Against ML-MMOH-SCF-2511\n\t\t$(\"#fppCat\"+arr[0]).prop(\'disabled\', false);\n\t\t}\t\n\t\n\tfunction fppCatValue(val)\n\t{\n\t\tparent.frames[0].document.forms[0].fpp_category.value = val;\n\t}\n\tfunction addToCollect(i)\n\t{\n\t\tvar formObj=document.forms[0];\n\t\tvar speciality_code_for_or1=\"\";\n\t\t//var obj=formObj.opercode_OR.value+\",\";\n\t\tvar obj=eval(\"formObj.opercode_OR_\"+i).value+\",\";\n\t\t//var speciality_code_for_or1=formObj.speciality_code_for_or1.value+\",\";\n\t\t//parent.frames[0].document.forms[0].codeCollect.value+=obj;\n\t\t//console.log(parent.frames[0].document.getElementById(\'codeCollect\'));\n\t\tparent.frames[0].document.getElementById(\'codeCollect\').value+=obj;\n\t\tif(parent.frames[0].document.forms[0].specialityCollect.value==\'\')\n\t\t{   \n\t\tspeciality_code_for_or1=eval(\"formObj.speciality_code_for_or1_\"+i).value;\n\t\tparent.frames[0].document.forms[0].specialityCollect.value=\",\"+speciality_code_for_or1+\",\";\n\t\t}else{\n\t\t\tspeciality_code_for_or1=eval(\"formObj.speciality_code_for_or1_\"+i).value;\n\t\t\tparent.frames[0].document.forms[0].specialityCollect.value+=speciality_code_for_or1+\",\";\n\t\t}\n\t\t//parent.frames[0].document.forms[0].specialityCollect.value=speciality_code_for_or1;\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=existing_order_hdg>\n<table cellpadding=2  cellspacing=0 border=1 width=\'98.8%\' >\n\t<tr>\n\t\t<th class=\"columnHeader\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</th>\t\t\n\t\t<th class=\"columnHeader\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</th>\t\t \n\t\t<th class=\"columnHeader\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</th>\n         ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<th class=\'columnHeaderCenter\' nowrap>\n\t\t    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</th>\n       <th class=\'columnHeaderCenter\' nowrap>\n       </th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</tr>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<input type=\'hidden\' name=\'opercode_OR_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'opercode_OR_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'   value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<input type=\'hidden\' name=\'speciality_code_for_or1_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'speciality_code_for_or1_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\n\t\t\t<script>\n\t\t\tsetTimeout(\"addToCollect(\"+";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="+\")\",500);\n\t\t\t</script>\n\t\t\t\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</table>\n<!-- Start PMG2014-CRF-0002 [IN:046043]-->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<br>\n\t<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t<td  width=\"25%\"></td>\n\t\t<td  width=\"25%\"></td>\n\t\t<td  width=\"25%\"></td>\n\t\t<td  width=\'4%\'>\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onClick=\'closeWindow()\'>\n\t\t</td>\n\t\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<!-- End PMG2014-CRF-0002 [IN:046043]-->\n<input type=\'hidden\' name=\'total_hour\' id=\'total_hour\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'total_min\' id=\'total_min\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\n<input type=\'hidden\' name=\'selectAuthFlag\' id=\'selectAuthFlag\' id=\'selectAuthFlag\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>  <!-- 049829 -->\n<input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<input type=\'hidden\' name=\'ammendFlag\' id=\'ammendFlag\' id=\'ammendFlag\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<input type=\'hidden\' name=\'strat_time\' id=\'strat_time\' id=\'strat_time\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n<input type=\'hidden\' name=\'fppCatFromORDesc\' id=\'fppCatFromORDesc\' id=\'fppCatFromORDesc\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><!--Added By Gaurav Against ML-MMOH-SCF-2511--> \n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String ot_bean_id = "OTBillingBean";
	String ot_bean_name= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;

	String or_bean_id 						= "Or_billingQueryBean";
	String or_bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)mh.getBeanObject( or_bean_id,request, or_bean_name ) ;
	
	// Added Against ML-MMOH-CRF-1939-US2...starts
	
    String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList Fpplist = new ArrayList();
    	String fpp_order_yn = "N";
	String fpp_category = ""; 
	String oper_code="";
	String selected1="",selected2="",selected3="";
	String Include_Fpp_yn = "N";
	String fppCatFromORDesc = "";
	boolean isIncludeFpp = false;
	Integer count = 0;
	int j;
	// Added Against ML-MMOH-CRF-1939-US2...ends
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String bill_flag = request.getParameter("bill_flag");
	String facility_id = (String)session.getValue("facility_id");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
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

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
if(("true").equals(bill_flag))
	      {
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

	//request parameter
	String strOrderId=checkForNull(request.getParameter("orderid"));
	String fppCatFromOR=checkForNull(request.getParameter("fpp_category")); //ML-MMOH-CRF-1939 US005
	System.err.println("fpp_category in Static Dtl===>"+fppCatFromOR);
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")).trim(); // ChAiTu - 186
	String ammendFlag = checkForNull(request.getParameter("ammendFlag")).trim(); // ChAiTu - 186
	if(selOrderIds != null && selOrderIds.contains(","))
		selOrderIds = selOrderIds.replaceAll(",", "','");
	String called_from=checkForNull(request.getParameter("called_from"));
	String surgeon_code=checkForNull(request.getParameter("surgeonCode"));
	String splty_code=checkForNull(request.getParameter("splty_code"));
	String mode=checkForNull(request.getParameter("mode"),"L");
	String selectAuthFlag = checkForNull(request.getParameter("selectAuthFlag")); //049829
	String patientId = checkForNull(request.getParameter("patientId"));
	String episode_id1 = "";//Added Against ML-MMOH-CRF-1939-US2
	String tempSelOrderIds = selOrderIds;
	System.out.println("====selectAuthFlag===OperationStaticDtl.jsp==="+selectAuthFlag);
	System.out.println("====selOrderIds===OperationStaticDtl.jsp==="+selOrderIds);
	System.out.println("====called_from===OperationStaticDtl.jsp==="+called_from);
	System.out.println("====patientId===OperationStaticDtl.jsp==="+patientId);
	System.out.println("====tempSelOrderIds===OperationStaticDtl.jsp==="+tempSelOrderIds);
	System.out.println("=========ammendFlag======OperationStaticDtl.jsp========="+ammendFlag);
	//variable initialization
	String empty = "".intern();
	String strOperationCode=empty;
	String strOperationDesc=empty;
	String strRightLeftFlag=empty;
	String strDuration=empty;
	String strRemarks=empty;
	String std_durn=empty;
	String surgeon_avg_time=empty;
	String strSide=empty;
	String durationSum=empty;
	String durationHour=empty;
	String durationMin=empty;
	String bill_str="";
	String panel_str="";
	String rate="";
	String ar[]=null;
	String order_line_num="";
	String ammendBooking = ""; //ChAiTu
	String chkBookingExistDays = ""; //ChAiTu
	String tempOrderCode="";//vikash Added For Duplicated Operation Code
	boolean temporderflag=true;//vikash Added For Duplicated Operation Code
	int CounterForOrderId=0;
	String orderArr[]=null;
	HashMap bill_info = new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	StringBuffer getOperDetsBuffer = new StringBuffer();
	int durH,durM;
	//int count=0;
	int fetchCount=0;
	//Database Related 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt1=null;
	ResultSet rst1=null;
	PreparedStatement pstmt2=null;
	ResultSet rst2=null;

	String overridden_action_reason_code=null;
	//getting Bean Reference 
    bean_id = "OperationDtlBean";
	bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);

	System.out.println("====strOrderId===OperationStaticDtl======"+strOrderId);
	System.out.println("====mode===OperationStaticDtl======"+mode);
	if(strOrderId.length()>0  && "L".equals(mode))
	{
			HashMap map;
			conn = ConnectionManager.getConnection(request);

		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
		String getValOfAmmendBooking = "select nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days from ot_param_for_facility where operating_facility_id = ?";
		pstmt = conn.prepareStatement(getValOfAmmendBooking);
		pstmt.setString(1,facility_id);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			ammendBooking = rs.getString("ammend_bookings");
			chkBookingExistDays = rs.getString("chk_bookings_exist_days");
		}
		System.out.println("=======ammendBooking=====OperationStaticDtl========="+ammendBooking);
		System.out.println("=======chkBookingExistDays===OperationStaticDtl==========="+chkBookingExistDays);
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();

			String surg_avg_time_sql = OTRepository.getOTKeyValue("SQL_OT_COLLECT_DURATION_SELECT2");
			String std_durn_sql ="SELECT TO_CHAR(APPT_TIME,'HH24:MI') APPT_TIME1, TO_CHAR(APPT_TIME,'DD/MM/YYYY HH24:MI') APPT_TIME2 FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID=? AND ORDER_CATEGORY = 'OT' AND ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE=?)";
			String duraiotn_ot_param_for_facility  ="SELECT TO_CHAR(UNIT_OT_TIME,'HH24:MI') OPER_DUR FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?";
			String speciality_code_for_or="";


		String sql = OTRepository.getOTKeyValue("SQL_OT_OPERATION_SERARCH_SELECT1");
		if(tempSelOrderIds == null || tempSelOrderIds.trim().length() == 0)
			tempSelOrderIds = strOrderId;
		System.out.println("====tempSelOrderIds===OperationStaticDtl======"+tempSelOrderIds);
		
		if(ammendFlag != null && ammendFlag.equals("Y"))
		{
		
		tempSelOrderIds=tempSelOrderIds.concat("','").concat(strOrderId);//186
		
		
/*
			getOperDetsBuffer.append("	SELECT DISTINCT oper_code oper_code1, oper_desc oper_desc1, order_id,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1,	");
			getOperDetsBuffer.append("	TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1,	");
			getOperDetsBuffer.append("	speciality_code FROM ot_pending_orders_dtl_vw	");
			getOperDetsBuffer.append("	WHERE order_id in('"+	tempSelOrderIds + "')	");
			getOperDetsBuffer.append("	AND oper_durn IS NOT NULL		");
			getOperDetsBuffer.append("	ORDER BY order_line_no	");
*/

			getOperDetsBuffer.append("	SELECT DISTINCT a.oper_code oper_code1, a.oper_desc oper_desc1,a.order_id order_id,	");//057524
			getOperDetsBuffer.append("	a.appl_right_left_flag appl_right_left_flag1, NVL (TO_CHAR (oper_durn, 'hh24:mi'),	");
			getOperDetsBuffer.append("	TO_CHAR (booking_duration, 'hh24:mi')) oper_durn1,	");
			getOperDetsBuffer.append("	a.oper_remarks oper_remarks1, a.order_line_no order_line_no1, a.speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw a, ot_booking_hdr b	");
			getOperDetsBuffer.append("	WHERE a.order_id IN ('"+	tempSelOrderIds + "')	");
			getOperDetsBuffer.append("	AND a.order_id = b.order_id(+)	");
			getOperDetsBuffer.append("	AND NVL (b.operating_facility_id, ?) = ?	");
			getOperDetsBuffer.append("	ORDER BY order_line_no	");
			
			System.err.println("207 if part query getOperDetsBuffer : "+getOperDetsBuffer);
			//MMS-QH-CRF-186 Added For Operation Failed while multiple Book Appointment
		}/*else if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0){
		
			System.err.println("came kin else if condition vikash");
			
			getOperDetsBuffer.append("	SELECT oper_code oper_code1, oper_desc oper_desc1,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1, TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1, speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw	");
			//getOperDetsBuffer.append("	WHERE order_id IN ('"+	strOrderId + "')	");
			getOperDetsBuffer.append("	WHERE order_id IN ('"+	tempSelOrderIds + "')	");
			getOperDetsBuffer.append("	ORDER BY order_line_no	");
			
		}*/
		else
		{
			//057524 starts
			getOperDetsBuffer.append("	SELECT oper_code oper_code1, oper_desc oper_desc1,order_id,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1, TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1, speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw	");
			getOperDetsBuffer.append("	WHERE order_id IN ('"+	strOrderId + "')	");
			getOperDetsBuffer.append("	union all	");
			//057524 ends
			//this above code added to displaying the selected operation first and making tat as primary Operation
			getOperDetsBuffer.append("	SELECT oper_code oper_code1, oper_desc oper_desc1,order_id,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1, TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1, speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw	");
			getOperDetsBuffer.append("	WHERE order_id IN ('"+	tempSelOrderIds + "')	");
			//getOperDetsBuffer.append("	ORDER BY order_line_no	");
			//getOperDetsBuffer.append("	order by oper_desc desc	");
			System.err.println("else part of OperationStaticDtl.jsp tempSelOrderIds: "+tempSelOrderIds);
			System.out.println("====else part == query getOperDetsBuffer===OperationStaticDtl======"+getOperDetsBuffer);
		}

		System.out.println("====getOperDetsBuffer===OperationStaticDtl======"+getOperDetsBuffer);
		try
		{
			pstmt = conn.prepareStatement(getOperDetsBuffer.toString());
			if(ammendFlag != null && ammendFlag.equals("Y"))
			{
				pstmt.setString(1, facility_id);
				pstmt.setString(2, facility_id);
			}

			rs=pstmt.executeQuery();
			//57524
			if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0 ){
			orderArr=selOrderIds.split(",");
			}
			//57524
			while(rs.next())
{
				System.err.println("vikash while starts :"+strOrderId);
				//Vikash starts for duplicated order remvoing	057524
				oper_code = rs.getString("OPER_CODE1");//Added Against ML-MMOH-CRF-1939-US2
				temporderflag=true;
				if(tempOrderCode.length()>0){
					System.err.println("tempOrderCode :"+tempOrderCode);
					
					if(tempOrderCode.contains(rs.getString("OPER_CODE1"))){
						temporderflag=false;
					}
				}
							
				tempOrderCode=tempOrderCode.concat(rs.getString("OPER_CODE1")).concat(",");
				System.err.println("tempOrderCode : "+tempOrderCode);
				//057524 ends
				
				//Vikash End for duplicated order remvoing
				if(temporderflag){
				//Vikash End for duplicated order remvoing
				fetchCount++;
				speciality_code_for_or=checkForNull(rs.getString("SPECIALITY_CODE"));
				strOperationCode=checkForNull(rs.getString("OPER_CODE1"));
				strOperationDesc=checkForNull(rs.getString("OPER_DESC1"));
				strRightLeftFlag=checkForNull(rs.getString("APPL_RIGHT_LEFT_FLAG1"));
				strDuration=checkForNull(rs.getString("OPER_DURN1"));
				strRemarks=checkForNull(rs.getString("OPER_REMARKS1"));
				
				System.err.println("ammendBooking :"+ammendBooking);
				if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0 ){
					order_line_num = String.valueOf(fetchCount);//186
					//57524
					strOrderId=rs.getString("order_id");
					//if(CounterForOrderId>=1){
					//strOrderId=orderArr[CounterForOrderId];
					//}
					//57524
					System.err.println("newly implementt strOrderId if "+strOrderId);
					System.err.println("order_line_num if "+order_line_num);
				}
				else {				
					order_line_num = checkForNull(rs.getString("ORDER_LINE_NO1"));
					System.err.println("order_line_num else ");
				}
				CounterForOrderId++;//57524

				System.err.println("order_line_num : OperationStaticDtl.jsp"+order_line_num);
				//for getting surgeon avg time from order
				pstmt1 = conn.prepareStatement(surg_avg_time_sql);
				pstmt1.setString(1,surgeon_code);
				pstmt1.setString(2,strOperationCode);
				rst1 = pstmt1.executeQuery();
				while(rst1.next()){
					surgeon_avg_time =checkForNull(rst1.getString(1),"ISNULL");
				}

				//for getting Standard Duration
				pstmt1 = conn.prepareStatement(std_durn_sql);
				pstmt1.setString(1,locale);
				pstmt1.setString(2,strOperationCode);
				rst1 = pstmt1.executeQuery();
				while(rst1.next()){
					std_durn = checkForNull(rst1.getString(2),"ISNULL");
				}
			if(pstmt1!=null)pstmt1.close();
			if(rst1!=null)rst1.close();

			if(strDuration.length()==0)
			{
			pstmt2=conn.prepareStatement(duraiotn_ot_param_for_facility);
			pstmt2.setString(1,facility_id);
			rst2=pstmt2.executeQuery();
			while(rst2.next())
				{
                strDuration=checkForNull(rst2.getString("OPER_DUR"));
				}
			}

			if(strDuration.length()>0){
				String arr[] = strDuration.split(":");
				durationHour=arr[0];
				durationMin=arr[1];
			}else{
				durationHour="0";
				durationMin="0";
			}
            if(("true").equals(bill_flag))
	        {

				if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0)
				{
					bill_info = or_bean.getOrderBillDtls(patientId + strOperationCode);
					//bill_info = or_bean.getOrderBillDtls(strOrderId+rs.getString("ORDER_LINE_NO1"));
					
					//bill_info = or_bean.getOrderBillDtls(strOrderId+order_line_num);
					bill_info = or_bean.getOrderBillDtls(rs.getString("order_id")+order_line_num);//057524 for null issue
				}
				else
				{
				bill_info = or_bean.getOrderBillDtls(strOrderId+order_line_num);
				}


				System.out.println("===========bill_info====111========"+bill_info);
				if((bill_info==null || bill_info.size()==0) && !"".equals(called_from))
				{
					bill_info = new HashMap();
					//bill_info.put("key",strOrderId);//commented against null issue
					bill_info.put("key",rs.getString("order_id"));//057524 for null issue
					//bill_info.put("key_line_no",order_line_num);//commented against null issue
					bill_info.put("key_line_no",rs.getString("ORDER_LINE_NO1"));	//057524 for null issue
					bill_info.put("oper_code",strOperationCode);
					bill_info.put("locale",locale);
					bill_info.put("module_id","OR");//after booking billing is done need to change.
					bill_info.put("quantity","1");
					bill_info.put("called_from",called_from);
					bill_info.put("fpp_category",fppCatFromOR); //ML-MMOH-CRF-1939-US005
					System.err.println("line 370 bill_info :"+bill_info);
					bill_info = billing_bean.getCheckInBillingParams(bill_info,"S");
					episode_id1 = (String)bill_info.get("episode_id");

					if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0)
					{
						//bill_info.put("order_id", "");//commented against null issue
						//or_bean.setOrderBillDtls(patientId + rs.getString("ORDER_LINE_NO1"), bill_info);//commented against null issue
						//or_bean.setOrderBillDtls(strOrderId+order_line_num,bill_info);//commented against null issue
						or_bean.setOrderBillDtls(rs.getString("order_id")+order_line_num,bill_info);	//057524 for null issue
						
					}
					else
					{
					or_bean.setOrderBillDtls(strOrderId+order_line_num,bill_info);
					}
					putObjectInBean(or_bean_id,or_bean,request);
				}
				System.out.println("===========bill_info====222========"+bill_info);
				String overridden_incl_excl=null;
				panel_str=checkForNull((String) bill_info.get("bl_panel_str"));
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("err_id"),""));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
			}
			
			Fpplist = billing_bean.getFPPDetails(strOperationCode);
			for (j = 0; j < Fpplist.size(); j++){
			  if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
              if(j==1) fpp_category=checkForNull((String)Fpplist.get(j));
			}

			map=new HashMap();
			map.put("oper_code",strOperationCode);
			map.put("operation_desc",strOperationDesc);
			map.put("appl_right_left_flag",strRightLeftFlag);
			map.put("duration",strDuration);
			map.put("remarks",strRemarks);
			map.put("surgeon_avg_time",surgeon_avg_time);
			map.put("f_duration",std_durn);
			map.put("splty_code",splty_code);
			if(("true").equals(bill_flag))
	        {
				//Added By Gaurav Against ML-MMOH-SCF-2511
				map.put("fpp_yn",fpp_order_yn);
				if(fpp_order_yn.equals("N"))
					map.put("fpp_category","N");
				else
					map.put("fpp_category",fppCatFromOR);
				//Added By Gaurav Against ML-MMOH-SCF-2511
				map.put("bill_str",bill_str);
				map.put("panel_str",panel_str);
				map.put("rate",rate);
			}
			map.put("order_id",strOrderId);
			map.put("order_line_num",order_line_num);
			System.out.println("==========map======OperationStaticDtl============"+map);
			chk_bean.recordOperationDtls(map);

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strOperationCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(speciality_code_for_or));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block20Bytes, _wl_block20);

}//vikash  if closing for removing duplicate oper code	057524 for duplicate order
}// while looping ending here
rs.close();
pstmt.close();
}catch(Exception ee){	
	//System.err.println("Exception OperationStaticDtl.jsp"+ee);
	ee.printStackTrace();
}finally{
	ConnectionManager.returnConnection(conn, request);	
}
}

	HashMap operation_Map=chk_bean.getOperationDtls();
	HashMap temp_map=new HashMap();
	StringBuffer sbr = new StringBuffer();
	String classvalue = ""; 
	String val = "";
	String choice = "D";
	durationHour=checkForNull(request.getParameter("total_hour"),"0");
	durationMin=checkForNull(request.getParameter("total_min"),"0");
	durH=Integer.parseInt(durationHour);
	durM=Integer.parseInt(durationMin);
	StringTokenizer strtoken;

	System.out.println("====operation_Map===OperationStaticDtl======"+operation_Map);
	for(int i=1;i<=operation_Map.size();i++)
	{
		temp_map=(HashMap)operation_Map.get(""+i);
//Added try catch block on March 3,2011 by Anitha for Booking Internal server error issue.
  try{
		if(("true").equals(bill_flag) )
	    {
			panel_str=checkForNull((String)temp_map.get("panel_str")); 
			bill_str=checkForNull((String)temp_map.get("bill_str")); 
			rate=checkForNull((String)temp_map.get("rate")); 
			if(!(bill_str.trim()).equals(""))
			{
		//modified dhanasekarV
		//bill_str = "20000.0::19071.8::0.0::N::null::::S::null::I";
		//	bill_str = bill_str+"E";
				ar=bill_str.split("::");
			}else
			{
				 bill_str="0.0::0.0::0.0::N::null::N::L::null::";
				 ar=bill_str.split("::");
			}
		// Added Against ML-MMOH-CRF-1939-US2...starts
			
			conn = ConnectionManager.getConnection(request);
			Include_Fpp_yn = bean.getIncludeFpp(facility_id);
			System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
			isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
			System.err.println("isIncludeFpp --->"+isIncludeFpp);
		//	isIncludeFpp = true;
	
			count = bean.getFppIcon();
			System.err.println("COunt : "+count);
			oper_code = (String)temp_map.get("oper_code");
		// Added Against ML-MMOH-CRF-1939-US2...ends
	    }
    }catch(Exception e){
		e.printStackTrace();
		//System.err.println("exp in OperationStaticDtl.jsp "+e);
   }

		durationSum=""+temp_map.get("duration");
		strtoken=new StringTokenizer(durationSum,":");
		if(strtoken.hasMoreTokens()){
			durationHour=strtoken.nextToken().trim();
			durationMin=strtoken.nextToken().trim();
		}
	
	durM+=Integer.parseInt(durationMin);
	durH+=Integer.parseInt(durationHour)+(durM/60);
	durM%=60;
	classvalue = (i%2==0)?"gridData":"gridData";
	out.println("<tr>");
	out.println("<input type='hidden' name='xx"+i+"' id='xx"+i+"'  value=\""+temp_map.get("remarks")+"\">"); 
	out.println("<input type='hidden' name='oper_code"+i+"' id='oper_code"+i+"'  value=\""+temp_map.get("oper_code")+"\">"); 
	out.println("<input type='hidden' name='operation_desc"+i+"' id='operation_desc"+i+"'  value=\""+temp_map.get("operation_desc")+"\">"); 
	out.println("<input type='hidden' name='appl_right_left_flag"+i+"' id='appl_right_left_flag"+i+"'  value=\""+temp_map.get("appl_right_left_flag")+"\">"); 
	out.println("<input type='hidden' name='duration"+i+"' id='duration"+i+"'  value=\""+temp_map.get("duration")+"\">"); 
	out.println("<input type='hidden' name='f_duration"+i+"' id='f_duration"+i+"'  value=\""+temp_map.get("f_duration")+"\">"); 
	out.println("<input type='hidden' name='avgTime"+i+"' id='avgTime"+i+"'  value=\""+temp_map.get("surgeon_avg_time")+"\">"); 
	out.println("<input type='hidden' name='splty_code"+i+"' id='splty_code"+i+"'  value=\""+temp_map.get("splty_code")+"\">"); 
	if(("true").equals(bill_flag))
		out.println("<input type='hidden' name='bill_st"+i+"' id='bill_st"+i+"'  value=\""+temp_map.get("bill_str")+"\">"); 
		out.println("<input type='hidden' name='order_line_num"+i+"' id='order_line_num"+i+"'  value=\""+temp_map.get("order_line_num")+"\">"); 
		//if(mode.equals("U"))
		out.println("<input type='hidden' name='fppCat"+i+"' id='fppCat"+i+"'  value=\""+temp_map.get("fpp_category")+"\">"); 
		sbr.append(i).append("::");
		sbr.append(temp_map.get("oper_code")).append("::");
		//Apostrophe Available in Operation Description
		String desc = temp_map.get("operation_desc").toString();
		String operationDesc = desc.replaceAll("'", "%");
		sbr.append(operationDesc).append("::");
		//Apostrophe**
		sbr.append(temp_map.get("appl_right_left_flag")).append("::");
		sbr.append(temp_map.get("duration")).append("::");
		sbr.append(temp_map.get("surgeon_avg_time")).append("::");
		sbr.append(temp_map.get("f_duration")).append("::");
		sbr.append(temp_map.get("splty_code")).append("::");
		sbr.append(temp_map.get("fpp_category"));
		val = sbr.toString();
		sbr.setLength(0);
		out.println("<td width='8%' class='"+classvalue+"' align='left' nowrap><a href=\"javascript:callUpdateDtl('"+val+"');\" >"+temp_map.get("oper_code")+"</a></td>");
		out.println("<td width='8%' align='left' class='"+classvalue+"' nowrap>"+temp_map.get("operation_desc")+"</td>");
		choice = checkForNull((String) temp_map.get("appl_right_left_flag"),"D");
	switch(choice.charAt(0)){
		case 'B': 
				strSide=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Bilateral.Label","ot_labels");
				break;
		case 'L': 
				strSide=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LeftSide.Label","ot_labels");
				break;
		case 'R': 
				strSide=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RightSide.Label","ot_labels");
				break;
		default:  
				strSide="";
				break;
	}
		
	out.println("<td width='8%' align='left' class='"+classvalue+"' nowrap>"+strSide+"</td>");
	out.println("<td width='8%' align='right'class='"+classvalue+"' nowrap>"+temp_map.get("duration")+"</td>");
    
	String inclexcl="";
	String approvalreqd="";

	  if(isIncludeFpp)
	{
	Fpplist = billing_bean.getFPPDetails(oper_code);
			for (j = 0; j < Fpplist.size(); j++){
			  if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
              if(j==1) fpp_category=checkForNull((String)Fpplist.get(j));
			}		
		if("S".equals(temp_map.get("fpp_category")) || "M".equals(temp_map.get("fpp_category")) || "C".equals(temp_map.get("fpp_category")))
			{
				if(temp_map.get("fpp_category").equals("S")) selected1="selected";
				if(temp_map.get("fpp_category").equals("M")) selected2="selected";
				if(temp_map.get("fpp_category").equals("C")) selected3="selected";
			}
		else
	{
		if(fpp_category.equals("S")) selected1="selected";
		if(fpp_category.equals("M")) selected2="selected";
		if(fpp_category.equals("C")) selected3="selected";
	}

	 if(fppCatFromOR!= "") //ML-MMOH-CRF-1939 US005
	{
			//fpp_order_yn = "Y";
			if(fppCatFromOR.equals("S")) fppCatFromORDesc="Simple";
			if(fppCatFromOR.equals("M")) fppCatFromORDesc="Moderate";
			if(fppCatFromOR.equals("C")) fppCatFromORDesc="Complex";
			}
	}
	if(("true").equals(bill_flag))
	{
	if(("S").equals(ar[6]))
	{
	if(("E").equals(ar[8]) ||("").equals(ar[8])) inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
	if(("I").equals(ar[8])) inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	if(("Y").equals(ar[5])) approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	if(("N").equals(ar[5])) approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	}else{
	inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
    approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
	}
	}
	
	
    if(("true").equals(bill_flag))
	{ 
	  //Added Against ML-MMOH-CRF-1939-US2...starts
	  if(fpp_order_yn.equals("Y") && called_from.equals("DIRECT_BOOKING") && isIncludeFpp && count==1 && Include_Fpp_yn.equals("Y") ){
	out.println("<td width='20%'align='left' class='"+classvalue+"' nowrap>"+"<div id='charge"+i+"'>"+"<B><font color='Indigo' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Payable.Label","ot_labels")+":&nbsp;"+ar[0]+"</font>&nbsp;<font color='crimson'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPayable.label","common_labels")+":&nbsp;"+ar[1]+"</font>&nbsp;<font color='green'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPaid.label","common_labels")+":&nbsp;"+ar[2]+"</font></B><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels")+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApprovalRequired.Label","common_labels")+approvalreqd+"<B><font color='Blue'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FppCategory.Label","ot_labels")+":&nbsp;"+"<select name = 'fppCat"+i+"' id = 'fppCat"+i+"'  onChange='javascript:fppCatValue(this.value)'; disabled><option value='S' "+selected1+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Simple.Label","ot_labels")+"</option><option value='M' "+selected2+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Moderate.Label","ot_labels")+"</option><option value='C' "+selected3+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Complex.Label","ot_labels")+"</option></select>"+"</td></div>"); //Added Against ML-MMOH-CRF-1939-US2...ends
	out.println("<td width='10%'align='left' class='"+classvalue+"'>"+"<a href='javascript:callBillingWindow1("+i+")';>"+"<img src='../../eOT/images/dollar.png'></img></a></td>");
	}
	else if(fpp_order_yn.equals("Y") && called_from.equals("OR") && isIncludeFpp && count==1 && Include_Fpp_yn.equals("Y") ) //ML-MMOH-CRF-1939 US005
	{
	out.println("<td width='20%'align='left' class='"+classvalue+"' nowrap>"+"<div id='charge"+i+"'>"+"<B><font color='Magenta' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FppCategory.Label","ot_labels")+":&nbsp;"+fppCatFromORDesc+"</font>&nbsp;<font color='Indigo' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Payable.Label","ot_labels")+":&nbsp;"+ar[0]+"</font>&nbsp;<font color='crimson'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPayable.label","common_labels")+":&nbsp;"+ar[1] +"</font>&nbsp;<font color='green'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPaid.label","common_labels")+":&nbsp;"+ar[2]+"</font></B><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels")+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApprovalRequired.Label","common_labels")+approvalreqd+"</td></div>");
	out.println("<td width='10%'align='left' class='"+classvalue+"'>"+"<a href='javascript:callBillingWindow1("+i+")';>"+"<img src='../../eOT/images/dollar.png'></img></a></td>");
	}
	else{
	out.println("<td width='20%'align='left' class='"+classvalue+"' nowrap>"+"<div id='charge"+i+"'>"+"<B><font color='Indigo' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Payable.Label","ot_labels")+":&nbsp;"+ar[0]+"</font>&nbsp;<font color='crimson'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPayable.label","common_labels")+":&nbsp;"+ar[1] +"</font>&nbsp;<font color='green'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPaid.label","common_labels")+":&nbsp;"+ar[2]+"</font></B><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels")+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApprovalRequired.Label","common_labels")+approvalreqd+"</td></div>");
	out.println("<td width='10%'align='left' class='"+classvalue+"'>"+"<a href='javascript:callBillingWindow1("+i+")';>"+"<img src='../../eOT/images/dollar.png'></img></a></td>");		
	 }
	}
	
}

	if(durH<=9) 
		durationHour="0"+durH;
	else 
		durationHour=""+durH;

	if(durM<=9) 
		durationMin="0"+durM;
	else	
		durationMin=""+durM;
	
	out.println("<tr ></tr><tr><td colspan='3' class='label' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TotalDuration.Label","ot_labels")+"</td><td class='label' align='left' colspan='3'>"+durationHour+":"+durationMin+"</td></tr>");
	
	if(sbr!=null)sbr.setLength(0);
	System.out.println("===durationHour===="+durationHour);
	System.out.println("===durationMin===="+durationMin);

            _bw.write(_wl_block21Bytes, _wl_block21);

	if(called_from.equalsIgnoreCase("OR")){

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

	}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(durationHour));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(durationMin));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(selectAuthFlag));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ammendFlag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getParameter("strat_time")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(fppCatFromORDesc));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationCode.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SideApplicable.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
