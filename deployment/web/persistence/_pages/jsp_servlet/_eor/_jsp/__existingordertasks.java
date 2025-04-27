package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __existingordertasks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingOrderTasks.jsp", 1731629846000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--<!DOCTYPE html>-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" <!-- line level -->\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<!-- Added for IN071315 -->\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  \n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t<!--IN29559,starts-->\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<!--IN29559,ends-->\n\t<!--IN061903 starts-->\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<!--IN061903 ends-->\n\t<!--IN072654 starts-->\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<!--IN072654 ENDS-->\n\t<!--IN061903 ends-->\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
19/10/2012    IN033061      Chowminya G  System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency).
07/08/2013	  IN042100      Chowminya G  Ph Category  -  Hold Order Option line level with MAR status P	
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L											An Audit Trail for Additional Information Amendment of Order	
10/05/2017		IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001		
10/07/2017		IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
18/07/2018              IN061961		sivabagyam M       18/07/2018		Ramesh G		GHL-CRF-0433
14/10/2019  	IN071315	    Nijitha S   		14/10/2019  	Ramesh G		GHL-CRF-0607
06/07/2020	  IN072654		Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
24/09/2020		IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String task_type = request.getParameter("colval1");
String iv_prep_yn = request.getParameter("iv_prep_yn");//--[IN033061]
String order_line_num = request.getParameter("order_line_num");
//String event_code = request.getParameter("event_code");//	IN061961//commented for checkstyle
//String catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");//	IN061961//commented for checkstyle
//String order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");//	IN061961//commented for checkstyle
if(iv_prep_yn == null) iv_prep_yn = ""; //IN042100 to avoid null value
if(order_line_num == null) order_line_num = "";
//IN049419 - Start
String bean_id1   = "Or_ExistingOrder" ;
String bean_name1 = "eOR.ExistingOrder";
ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1, request ) ;
bean1.setLanguageId(localeName);
String audit_reqd_yn = bean1.getOrderFormatAuditTrailYN();
String instrn_type = request.getParameter("instrn_type")==null?"T":request.getParameter("instrn_type");
String p_called_from_ca			=request.getParameter("p_called_from_ca");//Added for IN071315
String existing_order_called_from_new = ((String)request.getParameter("existing_order_called_from_new"))==null ? "" : (String)request.getParameter("existing_order_called_from_new");//IN074110
String patient_id	= request.getParameter("patient_id");//IN072654
String encounter_id	= request.getParameter("encounter_id");//IN072654
//IN049419 - End
//String view_by = request.getParameter("view_by")==null?"":request.getParameter("view_by"); //IN064215 //commented for checkstyle IN061961
/*
String orderId = request.getParameter("orderId");// order_id
String colval = request.getParameter("colval"); //order category desctription
String patient_id = request.getParameter("patient_id"); 
String sex =  request.getParameter("sex");
String image_ref =  request.getParameter("image_ref");

//if(patient_id == null) patient_id = "";
if(from == null) from = "";
*/    
//out.println(patient_id); 
//out.println(task_type);
//out.println(colval);
//out.println(sex);
/*
the fg 4 req.getparameter are used in cancel of line records - begin
*/
/*String ord_cat_id = request.getParameter("val1");
String ord_cat = request.getParameter("ord_cat");
String cancel_type = request.getParameter("cancel_type");

String cont_order_ind = request.getParameter("cont_order_ind");
if(cont_order_ind == null) cont_order_ind = "";
String order_status = request.getParameter("order_status");

//out.println("ord_cat = "+ord_cat);

if(ord_cat_id == null) ord_cat_id = "";
if(ord_cat == null) ord_cat = "";
if(cancel_type == null) cancel_type = "";
if(order_line_num == null) order_line_num = "";
*/
/* - end */

//out.println(">>orderId>>>"+orderId+"<<<");

/*the fg req.getparameter for line Preps- end*/
/*String catalog_code = request.getParameter("catalog_code");
if(catalog_code == null) catalog_code = "";
*/
/*the fg req.getparameter for line comments- end*/
//if(item_narration == null) item_narration = "";


//Added if condition in cancel task type --[IN033061]
	if((task_type.trim()).equals("View")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="ViewOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if(task_type.equals("Cancels")){
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page ="CancelOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Completion")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="CompleteOrder.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("UpdateOrder") || (task_type.trim()).equals("UpdateLine")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="ReviewStatus.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Cancel")){
		if((iv_prep_yn.trim()).equals("1") ||(iv_prep_yn.trim()).equals("2")||(iv_prep_yn.trim()).equals("3")||(iv_prep_yn.trim()).equals("4")||(iv_prep_yn.trim()).equals("5") )
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="CancelOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block5Bytes, _wl_block5);

		}
		else
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="CancelLineComment.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("p_called_from_ca"), weblogic.utils.StringUtils.valueOf(p_called_from_ca
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);
}
	}else if((task_type.trim()).equals("Preps")){
		//IN049419 - Start
		/* <jsp:include page="PrepsComment.jsp" /> */
		//IN64543, added instrn_type as param
		if(audit_reqd_yn.equalsIgnoreCase("N")){
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            {java.lang.String __page ="PrepsComment.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("instrn_type"), weblogic.utils.StringUtils.valueOf(instrn_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block5Bytes, _wl_block5);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="ViewOrderLineInstructions.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("instrn_type"), weblogic.utils.StringUtils.valueOf(instrn_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block5Bytes, _wl_block5);
}			
		//IN049419 - End
	}
	else if((task_type.trim()).equals("Comments")){
		//IN049419 - Start
		/* <jsp:include page="ViewLineComment.jsp" />  */
		if(audit_reqd_yn.equalsIgnoreCase("N")) {
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="ViewLineComment.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("instrn_type"), weblogic.utils.StringUtils.valueOf(instrn_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block8Bytes, _wl_block8);
 }
		else {
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="ViewOrderLineInstructions.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("instrn_type"), weblogic.utils.StringUtils.valueOf(instrn_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block5Bytes, _wl_block5);
	
		}
		//IN049419 - End
	}
	else if((task_type.trim()).equals("Instructions")){
		//IN049419 - Start
		/* <jsp:include page="ViewInstructions.jsp" /> */
		//IN64543, added instrn_type as param
		if(audit_reqd_yn.equalsIgnoreCase("N")) {
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="ViewInstructions.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("instrn_type"), weblogic.utils.StringUtils.valueOf(instrn_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block5Bytes, _wl_block5);
 }
		else {
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            {java.lang.String __page ="ViewOrderLineInstructions.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("instrn_type"), weblogic.utils.StringUtils.valueOf(instrn_type
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block8Bytes, _wl_block8);
	
		} //IN049419 - End
	}
	else if((task_type.trim()).equals("Review")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="ReviewOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Discontinue")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="DiscontinueOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Hold") && order_line_num.equals("")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="HoldOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Hold")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="HoldLineOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Resume")){
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="ResumeOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Result")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="ResultViewOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Refusal")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="RefusalOrderFrameset.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("Replace")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="ReplaceAddOrderable.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("ChangeChargeType")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            {java.lang.String __page ="ChangeChargeType.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block6Bytes, _wl_block6);
}else if((task_type.trim()).equals("ViewReplacedOrder")){
            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page ="ViewOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block15Bytes, _wl_block15);
}else if((task_type.trim()).equals("ViewOriginalOrder")){
            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page ="ViewOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block16Bytes, _wl_block16);
}else if((task_type.trim()).equals("RecordConsent")){
            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page ="ConsentOrders.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block17Bytes, _wl_block17);
}else if((task_type.trim()).equals("NotDone")){
            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page ="NotDone.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block18Bytes, _wl_block18);
}else if((task_type.trim()).equals("InteractionDtls")){
            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page ="OROrderDrugInteractionDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("encounter_id"), weblogic.utils.StringUtils.valueOf(encounter_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block19Bytes, _wl_block19);
}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
