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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __vieworderlineinstructionstop extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewOrderLineInstructionsTop.jsp", 1709120068000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style type=\'text/css\'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
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
 
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
28/07/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order										
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
--------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	String call_from = request.getParameter("from")==null?"":request.getParameter("from");
	String line = request.getParameter("line")==null?"":request.getParameter("line");
	String orderId = "";
	orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num");
	String field_mnemonic = request.getParameter("field_mnemonic");
	String max_seq = request.getParameter("max_seq");
	if(max_seq==null) max_seq="";
	String max_action_seq_num = max_seq;
	String can_reason = "Comments";
	int max_num = 0;
	String	audit_comments_reqd = request.getParameter("audit_comments_reqd")==null?"":request.getParameter("audit_comments_reqd"); // added for IN051122
	String	instrn_type = request.getParameter("instrn_type")==null?"":request.getParameter("instrn_type");//IN64543
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;

	if(max_action_seq_num.equals(""))
		max_action_seq_num		= bean.getOrderLineInstMaxCount(orderId, order_line_num, field_mnemonic);
	if(max_action_seq_num == null)
		max_action_seq_num = "";
	else 
		max_action_seq_num = max_action_seq_num.trim();
	
	max_num = Integer.parseInt(max_action_seq_num); 	
	if(max_num >1){
		for(int i=1; i<=max_num; i++){
			
			if(i==max_num){
				if(call_from.equalsIgnoreCase("line")) {	
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href=PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Instructions")) {
						//out.println("<a id='a"+i+"' href=ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {					
						//out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
				else {
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href=ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("DEPT_INSTRNS")) {
						//out.println("<a id='a"+i+"' href=ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("PATIENT_INSTRNS")) {					
						//out.println("<a id='a"+i+"' href=viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {	
						//out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
			}
			else {
				if(call_from.equalsIgnoreCase("line")) {	
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href =PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Instructions")) {
						//out.println("<a id='a"+i+"' href =ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {					
						//out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
				else {
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href =ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("DEPT_INSTRNS")) {
						//out.println("<a id='a"+i+"' href =ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("PATIENT_INSTRNS")) {					
						//out.println("<a id='a"+i+"' href =viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {					
						//out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
			}		
		}
	}	

            _bw.write(_wl_block9Bytes, _wl_block9);

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
}
