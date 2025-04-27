package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patientpendingordersresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PatientPendingOrdersResult.jsp", 1709119908000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- PatientPendingOrdersResult.jsp -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title>Active Orders</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../js/ExternalOrder.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\n\n</head>\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n     <script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t</script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'formPatientPendingOrders\' id=\'formPatientPendingOrders\'>\n<table name=\'\' id=\'\' border=\'1\' cellspacing=\'0\' cellpadding = \'0\' width=\'100%\' align=\'center\' class=\"grid\">\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<tr>\n\t\t<td colspan=\'100%\' align=\'left\' class =\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n<tr>\n\n\n\t<td  class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' width=\'16%\' align=left><font size=1>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td>\n\n\t<td  class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'10%\' align=left><font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' width=\'14%\' align=left><font size=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\n\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<td  class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'14%\' align=left><font size=1><a \thref=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a>\t</font></td>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t   <td  class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t</font></td>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</table>\n</form>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/* Mandatory checks start */
				String bean_id = "Or_PatOrderByPrivRelnBean" ;
				String bean_name = "eOR.PatOrderByPrivRelnBean";
				String practitioner_id = (String)session.getValue("ca_practitioner_id");
	/* Mandatory checks end */

	//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
		String mode	   = "1";//request.getParameter( "mode" ) ;
	
	bean.setLanguageId(localeName);	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
	//	String session_id= bean.getSessionId();
	//	String tmpstr =new String();
		String slClassValue = "";
	//	int count = 0;


	String Patient_id = request.getParameter("Patient_id") ;
	String encounter_id = bean.checkForNull(request.getParameter("encounter_id"),"");
	String patient_class = bean.checkForNull(request.getParameter("patient_class"),"");
	String discharge_indicator = bean.checkForNull(request.getParameter("discharge_indicator"),"");

	if( Patient_id==null || Patient_id.equals("")){
		Patient_id = "";
	}else {
		Patient_id = Patient_id.trim();
	}

	/*Patient_id = "RH00017171";
	encounter_id = "10";
	discharge_indicator = "Y";*/


	ArrayList searchData=new ArrayList();
	try{
        searchData=(ArrayList)bean.getModalResultDetails(Patient_id,practitioner_id,encounter_id,patient_class,discharge_indicator);
         if(searchData.size() == 0){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
    }catch(Exception e){
		e.printStackTrace();
	}



/* Initialize Function specific end */


            _bw.write(_wl_block10Bytes, _wl_block10);

try{
	String Pat_details = "";
	String Order_cat = "";
	//String Order_type = "";
	//String Loc_details = "";
	//String Date_details = "";
	String temp_grpby="";
	//String sex="";
	String Pat_Id="";
	String Order_Id="";
	String result_link="";
	//String Ord_status="";
	String cont_order_ind="";
	String Order_cat_code="";
	ArrayList GroupBy= null;

	for(int i=0;i<searchData.size();i++){
//	for(int i=0;i<10;i++){

	 GroupBy=(ArrayList)searchData.get(i);
	 Pat_details = (String)GroupBy.get(17);
	 Order_cat = (String)GroupBy.get(0);
	 Order_cat_code = (String)GroupBy.get(1);
	 //Order_type = (String)GroupBy.get(3);
	 //Loc_details = (String)GroupBy.get(10);
	// Date_details = (String)GroupBy.get(14);
	 //sex = (String)GroupBy.get(20);
	 Pat_Id = (String)GroupBy.get(11);
	 Order_Id = (String)GroupBy.get(13);
	 result_link=(String)GroupBy.get(22);
	// Ord_status = (String)GroupBy.get(16);
	 cont_order_ind=(String)GroupBy.get(23);

if(result_link == null || result_link.equals("null")) result_link =""; else result_link = result_link.trim();

if (!temp_grpby.equals(Pat_details)) {
			temp_grpby=Pat_details;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(temp_grpby));
            _bw.write(_wl_block12Bytes, _wl_block12);
}


		/*if(i % 2 == 0){
		slClassValue = "QRYEVEN";
		} else{ slClassValue = "QRYODD";*/
		slClassValue="gridData";
	

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)GroupBy.get(19)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)GroupBy.get(20)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)GroupBy.get(4)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)GroupBy.get(3)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)GroupBy.get(15)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)GroupBy.get(7)));
            _bw.write(_wl_block18Bytes, _wl_block18);
//if (encounter_id.equals("")) {
            _bw.write(_wl_block19Bytes, _wl_block19);
  if(result_link.equals("Y")) { 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Order_cat));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Order_Id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Pat_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Order_cat_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)GroupBy.get(16)));
            _bw.write(_wl_block27Bytes, _wl_block27);
 //}
            _bw.write(_wl_block28Bytes, _wl_block28);
}}
		GroupBy.clear();searchData.clear();

            _bw.write(_wl_block29Bytes, _wl_block29);

	}catch(Exception e)
	{
		e.printStackTrace();
	}
            _bw.write(_wl_block30Bytes, _wl_block30);

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
