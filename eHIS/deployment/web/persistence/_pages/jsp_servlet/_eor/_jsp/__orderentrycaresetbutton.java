package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrycaresetbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryCareSetButton.jsp", 1734000302000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-----------------------------------------------------------------------------------------\nDate       \t\tEdit History     \tName        Rev.Date  \t\t Rev.By\t\t\tDescription\n-----------------------------------------------------------------------------------------\n26/07/2018\t  \tIN064543\t\tKamalakannan\t26/07/2018\t\tRamesh G\t\tML-MMOH-CRF-0776\n------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name =\"careSetButtonForm\" id =\"careSetButtonForm\">\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td class=\"white\" align=\"right\">\n\t\t\t\t\t<!-- IN064543 start --><input type=\"button\" name=\"instrnBtn\" id=\"instrnBtn\" class=\"BUTTON\" value =\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onClick=\'openInstructionModalForOrderSet(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\")\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="><!-- IN064543 end -->\n\t\t\t\t\t<input type=\"button\" name=\"select\" id=\"select\" class=\"BUTTON\" value =\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \" onClick=\"setCareSet()\">\n\t\t\t \t</td>\n\t\t\t </tr>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"care_set_check_box_val\" id=\"care_set_check_box_val\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"N\">\n\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"ck";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"ck";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" value=\"Y\">\n\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"h1";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"h2";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t</form>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	//String patient_id					= request.getParameter("patient_id");
	//String encounter_id					= request.getParameter("encounter_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 						= request.getParameter("bean_id");
	String bean_name 					= request.getParameter("bean_name");
	String function_from 			= request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String care_set_order				= "";
	String care_set_value				= "N";
	//IN064543 start
	String order_catalog_nature			= "S";
	String patient_class				= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String encounter_id					= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String admission_date				= request.getParameter("admission_date")==null?"":request.getParameter("admission_date");
	String discharge_date_time			= request.getParameter("discharge_date_time")==null?"":request.getParameter("discharge_date_time");
	String practitioner_type			= request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");
	String enbDis =  request.getParameter("enbDis")==null?"disabled": request.getParameter("enbDis");
	//IN064543 end
	/* Mandatory checks end */
	/* Initialize Function specific	 start */
		//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		 bean.setLanguageId(localeName);

		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	/* Initialize Function specific end */
	String care_sets					= bean.checkForNull(request.getParameter("care_sets"));
	//String ammend_called_from			= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_category				= bean.checkForNull(request.getParameter("order_category"),"CS").trim();
	if(!order_category.equalsIgnoreCase("PH"))
		order_category					= "CS";
	String key							= (bean.getPatientId()+bean.getEncounterId());
	String keyItems[]					= null;
	String entryValue					= null;
	java.util.HashMap previousValues	= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
	if(previousValues!=null)
	{
		Set setValues 		 = previousValues.keySet();
		Iterator iterator 	 = setValues.iterator();
		// At the most there will be only one record for the caresets
		for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		{
			entryValue = ((String)iterator.next()) ;
			keyItems	= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
			if( keyItems[0].equals("ck"))     // If it is a check Box
			{
				care_set_value = keyItems[1];
				care_set_order = (String)previousValues.get("h1"+keyItems[1]) ;
				if(care_set_order.equalsIgnoreCase("CS") || care_set_order.equalsIgnoreCase("PH"))
					care_set_value = "Y";
				else
					care_set_value = "N";
			}
		} // End of for
	} // End of if

            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(care_sets ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_catalog_nature ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(admission_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(enbDis));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(care_set_value));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(care_sets));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block26Bytes, _wl_block26);

	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);	

            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Instruction.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
