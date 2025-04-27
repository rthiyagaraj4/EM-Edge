package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import webbeans.eCommon.ConnectionManager;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patorderbylocnsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PatOrderByLocnSearch.jsp", 1709119910000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!--  \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n -->\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n  \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/PatOrderByLocn.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"populateLocationOnChange(document.PatOrderByLocnSearch.location_type);FillOrderType(document.PatOrderByLocnSearch.order_category);\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n\n\t<form name=\"PatOrderByLocnSearch\" id=\"PatOrderByLocnSearch\">\n\t\t<table cellpadding=0 cellspacing=0   width=\"100%\" align=center>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=right >Period</td>\n\t\t\t\t<td class=\"label\" align=left >\n\t\t\t\t\t<input type=\"text\" name=\"period_from\" id=\"period_from\"  size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=right >To</td>\n\t\t\t\t<td class=\"label\" align=left >\n\t\t\t\t\t<input type=\"text\" name=\"period_to\" id=\"period_to\"  size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=\"right\" >Status</td>\n\t\t\t\t<td class=\"label\" align=\"left\">\n\t\t\t\t\t<select name=\"status\" id=\"status\" >\n\t\t\t\t\t\t<option value=\"Z\">-----All----</option>\n\t\t\t\t\t\t<option value=\"A\">Active</option>\n\t\t\t\t\t\t<option value=\"C\">Completed</option>\n\t\t\t\t\t\t<option value=\"D\">Discontinued/Cancelled</option>\n\t\t\t\t\t\t<option value=\"P\">Pending For Authorization</option>\n\t\t\t\t\t\t<option value=\"O\">Outstanding</option>\n\t\t\t\t\t\t<option value=\"H\">Suspended</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=right >Order Category</td>\n\t\t\t\t<td class=\"label\" align=left >\n\t\t\t\t\t<select name=\"order_category\" id=\"order_category\"   onChange=\"FillOrderType(this);\">\n\t\t\t\t\t\t<option value=\"\">----All----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"align=right >Order Type</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t\t<select name=\"order_type\" id=\"order_type\" >\n\t\t\t\t\t\t<option value=\"\">----All----</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=\"right\" >Ordering Practitioner</td>\n\t\t\t\t<td class=\"label\" align=\"left\" >\n\t\t\t\t\t <select name=\"ordering_pract\" id=\"ordering_pract\">\n\t\t\t\t\t\t<option value=\"\">----All----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t<option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=right >Location Type</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t<select name=\"location_type\" id=\"location_type\" onChange=\"populateLocationOnChange(this);\">\n\t\t\t\t\t<option value=\"\">----All----</option>\n\t\t\t\t\t<option value=\"C\">Clinic</option>\n\t\t\t\t\t<option value=\"N\">Nursing Unit</option>\n\t\t\t\t</select>\n\t\t\t\t<td class=\"label\" align=right >Location From</td>\n\t\t\t\t<td class=label align=\"left\">\n\t\t\t\t\t<select name=\"locn\" id=\"locn\">\n\t\t\t\t\t\t<option value=\"\">All</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=label align=\"right\"  >To</td>\n\t\t\t\t<td class=\"label\" align=\"left\">\n\t\t\t\t\t<select name=\"locn1\" id=\"locn1\">\n\t\t\t\t\t\t<option value=\"\">All</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=right >Patient ID</td>\n\t\t\t\t<td class=\"label\" align=\"left\" >\n\t\t\t\t\t<input type=\"text\" name=\"patient_id\" id=\"patient_id\" value=\"\" onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"ChangeUpperCase(this)\" size=\"20\" maxlength=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t<input align=\"right\" type=\"button\" name=search value=\"?\"  class=\"button\" onClick=\"callPatientSearch()\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=right >Encounter ID</td>\n\t\t\t\t<td class=\"label\" align=\"left\" >\n\t\t\t\t\t<input type=\"text\" name=\"encounter_id\" id=\"encounter_id\" value=\"\" onKeyPress=\"return CheckForSpecChars(event)\" size=\"12\" maxlength=\"12\">\n\t\t\t\t</td>\n\t\t\t\t<td class=label align=\"right\">Order ID</td>\n\t\t\t\t<td class=label align=\"left\" >\n\t\t\t\t\t<input name=\"order_id\" id=\"order_id\" type=\"text\" size=\"15\" maxlength=\"15\" onKeyPress=\"return CheckForSpecChars(event)\"></td>\n\t\t\t\t<td class=\"label\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=right >Order Catalog</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t\t<input type=\"text\"  name=\"order_catalog\" id=\"order_catalog\" value=\"\" onKeyPress=\"return CheckForSpecChars(event)\" maxlength=\"20\" size=\"20\">\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=right >Search Criteria</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t\t<select name=\"search_crt\" id=\"search_crt\">\n\t\t\t\t\t\t<option value=\"C\">Contain</option>\n\t\t\t\t\t\t<option value=\"S\">Starts With</option>\n\t\t\t\t\t\t<option value=\"E\">Ends With</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\"3\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=right >Group By</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t\t<input type=\"radio\" name=\"group_by\" id=\"group_by\" value=\"ORC\">Order Category\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=left >\n\t\t\t\t\t<input type=\"radio\" name=\"group_by\" id=\"group_by\" value=\"ORT\">Order Type\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t\t<input type=\"radio\" name=\"group_by\" id=\"group_by\" value=\"CAT\">Order Catalog\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\" align=left>\n\t\t\t\t\t<input type=\"radio\" name=\"group_by\" id=\"group_by\" value=\"LOC\" CHECKED>Location\n\t\t\t\t</td>\n\t\t\t\t<td align=left ><input type=button class=button name=\"search\" id=\"search\" value=\"Search\" onClick=\"populateValues()\"><input type=button name=\'clear\' id=\'clear\' class=button value=\"Clear\" onClick=\"clearValues()\">\n\t\t\t\t<td></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t</form>\n</body>\n</html>\n\n";
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eOR.PatOrderByPrivRelQueryBean beanObj= null;{
                beanObj=(eOR.PatOrderByPrivRelQueryBean)pageContext.getAttribute("beanObj");
                if(beanObj==null){
                    beanObj=new eOR.PatOrderByPrivRelQueryBean();
                    pageContext.setAttribute("beanObj",beanObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   		= request.getParameter( "mode" ) ;
	//String function_id 	= request.getParameter( "function_id" ) ;
	String bean_id 	 	= "Or_PatOrderByLocnBean" ;
	String bean_name 	= "eOR.PatOrderByLocnBean";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null) practitioner_id = "";


/* Mandatory checks end */

	/* Initialize Function specific start */
	//PatOrderByLocnBean bean = (PatOrderByLocnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 PatOrderByLocnBean bean = (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;
	/* Initialize Function specific end */
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;
	Properties properties		= (Properties) session.getValue( "jdbc" );  

	int patient_id_length = bean.getPatientIdLength();
	String curr_sys_date 	= "";
	String curr_week_date  	= "";
	String last_week_date  	= "";

	ArrayList sysdate 		= (ArrayList)bean.getSysDateTime();
		for(int i=0;i<sysdate.size();i++){
			last_week_date 		=  (String)sysdate.get(0);
			curr_week_date 		=  (String)sysdate.get(1);
			curr_sys_date 		=  (String)sysdate.get(2);
		}
		ArrayList OrderCategory = bean.getOrderCategory();
		ArrayList PracType		=	beanObj.getPractitionerID(properties);



	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(curr_week_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(last_week_date));
            _bw.write(_wl_block8Bytes, _wl_block8);
      if(OrderCategory!=null && OrderCategory.size()>0){
							String[] order_cat = null;
								for(int i=0;i<OrderCategory.size();i++){
									order_cat = (String[])OrderCategory.get(i);
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_cat[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_cat[1]));
            _bw.write(_wl_block11Bytes, _wl_block11);
	   }
						}
					
            _bw.write(_wl_block12Bytes, _wl_block12);
      if(PracType!=null && PracType.size()>0){
							String[] record = null;
								for(int i=0;i<PracType.size();i++){
									record = (String[])PracType.get(i);
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block11Bytes, _wl_block11);
  	}
						}	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
//=bean.getFunctionId()
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block20Bytes, _wl_block20);

	putObjectInBean(bean_id,bean,request);


            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
