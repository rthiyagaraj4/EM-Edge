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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patorderbylocnvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PatOrderByLocnValidate.jsp", 1732515092000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String bean_id = request.getParameter( "bean_id" ) ;
String bean_name = request.getParameter( "bean_name" ) ;
String func_mode = request.getParameter( "func_mode" ) ;

String practitioner_id = (String)session.getValue("ca_practitioner_id");
String facility_id=(String)session.getValue("facility_id");


if ( bean_id == null || bean_id.equals( "" ) )
		return ;
if ( bean_name == null || bean_name.equals( "" ) )
		return ;


if ( func_mode == null || func_mode.equals( "" ) )
		return ;



//PatOrderByLocnBean beanObj = (PatOrderByLocnBean)mh.getBeanObject( bean_id, request , bean_name) ;
PatOrderByLocnBean beanObj = (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;

String[] record	= null;


Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;

	if(func_mode!=null && func_mode.equals("order_cat"))
	{
		String locn_type = (String)hash.get("location_type") ;
		if ( locn_type == null || locn_type.equals( "" ) )
		locn_type="";
		out.println( "clearList('document') ; " ) ;

		ArrayList LocationType = beanObj.getLocation(locn_type,practitioner_id,facility_id) ;
		for( int i=0 ; i< LocationType.size() ; i++ ) {
			record = (String[])LocationType.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}
	else if(func_mode!=null && func_mode.equals("order_type"))
	{
		String order_category = (String)hash.get("order_category") ;
		if ( order_category == null || order_category.equals( "" ) )
				order_category="";
		out.println( "clearList1('document') ; " ) ;
		ArrayList OrderTypeData = beanObj.getOrderType(order_category) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			 record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}
	else if(func_mode!=null && func_mode.equals("populate_patients"))
	{
		String code 		= request.getParameter( "code" ) ;
		String rows 		= request.getParameter( "rows" ) ;
		String old_val		= rows;
		String description	= "";
		ArrayList PatientDetails = beanObj.getNursingUnitPatientDetails(code) ;
		StringBuffer htmlText	= new StringBuffer();
		if(PatientDetails!=null && PatientDetails.size() > 0)
			htmlText.append(" <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< PatientDetails.size() ; i++ ) {

			record = (String[])PatientDetails.get(i);

			description			= record[0]; // Patient Details
			// Replace the special characters with some special symbol so that they can be replaced  later
			description			= description.replace(' ','ö');
			description			= description.replace('>','ø');
			description			= description.replace('\'','ù');
			// Create a table and insert into the one TD
			htmlText.append(" <tr> ");
			htmlText.append("	<td CLASS='OR_WHITE' width='100%' id=patdtl_"+old_val+i+">");
			htmlText.append("  		<a href=javascript:expandCategory('"+old_val+"','"+i+"','"+record[1]+"',escape('"+description+"'))>");
			htmlText.append("			+&nbsp;"+ record[0]);
			htmlText.append("		</a>&nbsp;");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append("	<td CLASS='OR_WHITE'>");
			htmlText.append("		<div id=thirdinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append(" 				<tr>");
			htmlText.append( "					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=thirdlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(PatientDetails!=null && PatientDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addPatientDetails(\""+old_val+"\" ,\"" + htmlText.toString() +"\") ; " ) ;
	}
	else if(func_mode!=null && func_mode.equals("populate_categories"))
	{
		String old_val 		= request.getParameter( "old_val" ) ;
		String patient_id 	= request.getParameter( "patient_id" ) ;
		String curr_val 	= request.getParameter( "curr_val" ) ;
		old_val				= old_val+curr_val;
		ArrayList CategoryDetails = beanObj.getCategoryDtls(patient_id) ;
		StringBuffer htmlText	= new StringBuffer();
		String description	= "";
		if(CategoryDetails!=null && CategoryDetails.size() > 0)
			htmlText.append(" <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< CategoryDetails.size() ; i++ ) {
			// Create a table and insert into the one TD
			record = (String[])CategoryDetails.get(i);

			description			= record[0]; // Category Details
			// Replace the special characters with some special symbol so that they can be replaced  later
			description			= description.replace(' ','ö');
			description			= description.replace('>','ø');
			description			= description.replace('\'','ù');
			htmlText.append(" <tr>");
			htmlText.append("	<td CLASS='OR_WHITE' width='100%' id=catdtl_"+old_val+i+">");
			htmlText.append("		<a href=javascript:expandOrderType('"+old_val+"','"+i+"','"+record[1]+"','"+record[2]+"',escape('"+description+"'))>");
			htmlText.append("			+&nbsp"+record[0] );
			htmlText.append("		</a>&nbsp;");
			htmlText.append(" 	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE'>");
			htmlText.append("		<div id=fourthinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append("				<tr>");
			htmlText.append("					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=fourthlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(CategoryDetails!=null && CategoryDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addCategoryDetails(\""+old_val+"\" ,\"" + htmlText.toString() +"\") ; " ) ;
	}
	else if(func_mode!=null && func_mode.equals("populate_order_type"))
	{
		String patient_id 		= request.getParameter( "patient_id" ) ;
		String curr_val 		= request.getParameter( "curr_val" ) ;
		String old_val 			= request.getParameter( "old_val" ) ;
		old_val					= old_val+curr_val;
		String order_category	= request.getParameter( "order_category" ) ;
		ArrayList OrderTypeDetails = beanObj.getOrderTypeDtls(patient_id,order_category) ;
		StringBuffer htmlText	= new StringBuffer();
		String description		= "";
		if(OrderTypeDetails!=null && OrderTypeDetails.size() > 0)
			htmlText.append(" <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< OrderTypeDetails.size() ; i++ ) {
			// Create a table and insert into the one TD
			record 				= (String[])OrderTypeDetails.get(i);

			description			= record[1];
			// Replace the special characters with some special symbol so that they can be replaced  later
			description			= description.replace(' ','ö');
			description			= description.replace('>','ø');
			description			= description.replace('\'','ù');

			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE' width='100%' id=orderdtl_"+old_val+i+">");
			htmlText.append(" 		<a href=javascript:expandOrders('"+old_val+"','"+i+"','"+patient_id+"','"+order_category+"','"+record[0]+"',escape('"+description+"'))>");
			htmlText.append(" 			+&nbsp;"+record[1] );
			htmlText.append(" 		</a>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE'>");
			htmlText.append("		<div id=fifthinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append("				<tr>");
			htmlText.append(" 					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=fifthlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(OrderTypeDetails!=null && OrderTypeDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addOrderTypeDetails(\""+old_val+"\" ,\"" + htmlText.toString()+"\") ; " ) ;
	}
	else if(func_mode!=null && func_mode.equals("populate_orders"))
	{
		String patient_id 		= request.getParameter( "patient_id" ) ;
		String curr_val 		= request.getParameter( "curr_val" ) ;
		String old_val 			= request.getParameter( "old_val" ) ;
		String order_category	= request.getParameter( "order_category" ) ;
		String order_type_code	= request.getParameter( "order_type_code" ) ;
		old_val					= old_val+curr_val;
		ArrayList OrderDetails  = beanObj.getOrderDtls(patient_id,order_category,order_type_code) ;
		StringBuffer htmlText	= new StringBuffer();
		if(OrderDetails!=null && OrderDetails.size() > 0)
			htmlText.append( " <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< OrderDetails.size() ; i++ ) {
			// Create a table and insert into the one TD
			record 				= (String[])OrderDetails.get(i);
			htmlText.append(" <tr>");
			htmlText.append("	<td CLASS='OR_WHITE' width='93%'>");
			htmlText.append(" 		<a href=javascript:populateFrame('"+old_val+"','"+i+"','"+patient_id+"','"+order_category+"','"+order_type_code+"')>");
			htmlText.append(" 			+&nbsp;"+ record[0] );
			htmlText.append("		</a>&nbsp;");
			htmlText.append("	</td>");
			htmlText.append("	<td width='5%'  CLASS='OR_WHITE'>");
			htmlText.append("		<font size ='1' color='black'>(<b>"+record[1]+"</b>)</font>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE' colspan='2'>");
			htmlText.append("		<div id=sixthinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append(" 				<tr>");
			htmlText.append(" 					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=sixthhlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(OrderDetails!=null && OrderDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addDetails(\""+old_val+"\" ,\"" + htmlText.toString() +"\") ; " ) ;
	}
 

	putObjectInBean(bean_id,beanObj,request);


            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
