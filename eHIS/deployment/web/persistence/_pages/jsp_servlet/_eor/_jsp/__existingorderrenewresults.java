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

public final class __existingorderrenewresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingOrderRenewResults.jsp", 1709119696000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'formPatientPendingOrders\' id=\'formPatientPendingOrders\'>\n<table name=\'\' id=\'\' border=\'1\' cellspacing=\'0\' cellpadding = \'3\' width=\'100%\' align=\'center\' class=\"grid\">\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n\t\t<td colspan=\'100%\' align=\'left\' class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\n<tr>\n\n\n\t<td  class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\'16%\' ><font size=1>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></td>\n\n\t<td  class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\'10%\' ><font size=1>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'14%\' ><font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' width=\'14%\' ><font\n\t\tsize=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t</font></td>\n</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</table>\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'ord_typ_code\' id=\'ord_typ_code\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n</form>\n</Body>\n</Html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 


    	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
				String bean_id = "Or_PatOrderByPrivRelnBean" ;
				String bean_name = "eOR.PatOrderByPrivRelnBean";
//				String practitioner_id = (String)session.getValue("ca_practitioner_id");
	/* Mandatory checks end */

		//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		PatOrderByPrivRelnBean	 bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);

		String mode	   = "1";//request.getParameter( "mode" ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
		//String session_id= bean.getSessionId();
		//String tmpstr =new String();
		String slClassValue = "";
		//int count = 0;


//	String Patient_id = request.getParameter("Patient_id") ;
	String order_id    = request.getParameter("order_id");
	if (order_id == null) order_id = "";
	String order_line_num = request.getParameter("order_line_num");
	if (order_line_num == null) order_line_num = "";
	String Order_type_code = "";
	/*if( Patient_id==null || Patient_id.equals("")){
			out.println("<script>alert('Patient id is Null');</script>");
	}else {
		Patient_id = Patient_id.trim();
	}*/

	ArrayList searchData=new ArrayList();
	try{
	 //searchData=(ArrayList)bean.getModalRenewResultDetails(Patient_id,practitioner_id,order_id,order_line_num);
	 searchData=(ArrayList)bean.getModalRenewResultDetails(order_id);

	}catch(Exception e){
		out.println("Exception in search function::"+e);
	}
//  out.println(searchData.size());


/* Initialize Function specific end */


            _bw.write(_wl_block9Bytes, _wl_block9);

try{
	String Pat_details = "";
	
	//String Order_cat = "";
	//String Order_type = "";
	//String Loc_details = "";
	//String Date_details = "";
	String temp_grpby="";
	String priority="";
	//String sex="";
	//String Pat_Id="";
	//String Order_Id="";
	//String result_link="";
	//String Ord_status="";
	//String cont_order_ind="";
	//String Order_cat_code="";

	for(int i=0;i<searchData.size();i++){

	ArrayList GroupBy=(ArrayList)searchData.get(i);
	  Pat_details = (String)GroupBy.get(17);
	  Order_type_code = (String)GroupBy.get(2);
	 //Order_cat = (String)GroupBy.get(1);
	 //Order_cat_code = (String)GroupBy.get(0);
	 //Order_type = (String)GroupBy.get(3);
	 //Loc_details = (String)GroupBy.get(10);
	// Date_details = (String)GroupBy.get(14);
	// sex = (String)GroupBy.get(20);
	// Pat_Id = (String)GroupBy.get(11);
	 //Order_Id = (String)GroupBy.get(13);
	 //result_link=(String)GroupBy.get(21);
	// Ord_status = (String)GroupBy.get(16);
	// cont_order_ind=(String)GroupBy.get(22);
	 
				//	System.out.println("==="+register_details[11]);
if (Pat_details.indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(Pat_details,",");
			Pat_details="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			Pat_details=Pat_details.concat(tempToken).concat(",");
			  
         

		}
					 }
		


	if(((String)GroupBy.get(4)).equals("R")){
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
				else if(((String)GroupBy.get(4)).equals("U"))
				{
					
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					
				}
					else if(((String)GroupBy.get(4)).equals("S"))
				{
					
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					
				}

//if(result_link == null || result_link.equals("null")) result_link =""; else result_link = result_link.trim();

if (!temp_grpby.equals(Pat_details)) {
			temp_grpby=Pat_details;

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block11Bytes, _wl_block11);
}


		/*if(i % 2 == 0){
		slClassValue = "QRYEVEN";
		} else{ slClassValue = "QRYODD";
	}*/
	slClassValue="gridData";	

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)GroupBy.get(18)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)GroupBy.get(19)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)GroupBy.get(15)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
}catch(Exception e){
		//out.println(e.getMessage());
		e.printStackTrace();//COMMON-ICN-0181
	}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Order_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block25Bytes, _wl_block25);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ActiveOrders.label", java.lang.String .class,"key"));
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
