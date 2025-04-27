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
import java.util.*;
import com.ehis.util.*;

public final class __ordersetresultsviewtree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetResultsViewTree.jsp", 1709119858000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eOR/html/ORMainMenu.css\"></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/ORMainMenu.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/ExistingOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- added to include the function for viewing the results onclicking the status hyperlink -->\n\t<script>\n\tfunction dummy(){\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<FORM METHOD=POST ACTION=\"\" name=\"frmMenu\" id=\"frmMenu\">\n<script> \n\t \n\t\tvar obj;\n\t\tobj = new dTree(\'obj\');\n\t\tobj.add(0,-1,\'<font size=1 style=font-weight:bold style=color:#333><a class=\"gridLink\" href=\"#\" onClick=\"showOrderSetResults()\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a></font>\');\n\t\tobj.config.useStatusText=true;\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\")); \n \t\t\tparent.window.close();\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t   \t\tobj.add(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="1\",\"0\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"\",\"\",\"\",\"\");\n\t\t\t\t\tobj.add(\"OPTION_ID";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="1\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\",\"\",\"\",\"\",\"\");\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n \t\t\t\t\tobj.add(\"OPTION_ID";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</script>\n\t<input type=\"hidden\" name=\"txtNodePoistions\" id=\"txtNodePoistions\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n \t<input type=\"hidden\" name=\"txtCurrentPosition\" id=\"txtCurrentPosition\" value=\"\">\n\t<input type=\"hidden\" name=\"txtToolTips\" id=\"txtToolTips\" value=\"\">\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<script>\n \t\tdocument.write(obj);\n\t\tobj.openAll();\n   \t\tparent.ExistingOrderSetViewResult.location.href=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n  \t</script>\n\n </form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	/* Mandatory checks start */
	//String mode			= "1";//request.getParameter( "mode" ) ;
	//String function_id	= request.getParameter( "function_id" ) ;
	
	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
	String bean_name	= "eOR.ExistingOrder";

	ArrayList allValues = new ArrayList();
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	//bean.setMode( mode ) ;
 

            _bw.write(_wl_block2Bytes, _wl_block2);

	String patientId		= request.getParameter( "patientId" ) ;
	String encntr_id		= request.getParameter( "encntr_id" ) ;
	String order_status		= request.getParameter( "ord_status" ) ;
		order_status		= "Z"; // By default make the order_status as "Z", should bring the record for all status
	String order_by			= request.getParameter( "order_by" ) ;
	String catalog			= request.getParameter( "catalog" ) ;
	String view				= request.getParameter( "view" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String date_from		= request.getParameter( "date_from" ) ;
	String date_to			= request.getParameter( "date_to" ) ;
	String order_category	= request.getParameter( "order_category" ) ;
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String catalog_desc		= request.getParameter("catalog_desc");
	String orderId			= request.getParameter( "orderId" ) ; // Will get orderId only if it is for OrderSet results
	String practitioner_type = (String)session.getValue("practitioner_type");

	String order_grouping_category = "";
	String executable_name		   = "../../eOR/jsp/OrderSetResultsView.jsp?"+request.getQueryString();
	String workAreaFrame		   = "ExistingOrderSetViewResult";
	String query_executable_name   = "";
	String order_line_num		   = "";
 	String[] existing_details = null;
	int i	= 0;
  	if(patientId != null )patientId = patientId.trim();			else patientId = "";
	if(encntr_id != null )encntr_id = encntr_id.trim();			else encntr_id = "";
	if(orderId != null )orderId = orderId.trim();				else orderId = "";
	if(view != null )view = view.trim();						else view = "";
	if(order_status != null )order_status = order_status.trim();else order_status = "";
	if(priority != null )priority = priority.trim();			else priority = "";
	if(date_from != null )date_from = date_from.trim();			else date_from = "";
	if(date_to != null )date_to = date_to.trim();				else date_to = "";
	if(order_category != null )order_category = order_category.trim();	else order_category = "";
	if(order_type != null )order_type = order_type.trim();		else order_type = "";
	if(catalog != null )catalog = catalog.trim();				else catalog = "";
	if(search_criteria != null )search_criteria = search_criteria.trim();	else search_criteria = "";
	if(order_by != null )order_by = order_by.trim();			else order_by = "";
	if(view_by != null )view_by = view_by.trim();				else view_by = "";
	if(catalog_desc != null )catalog_desc = catalog_desc.trim();				else catalog_desc = ""; 
  	allValues		= bean.getOrderSetSearchDetails(view,patientId,encntr_id,order_status,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, orderId,practitioner_type);
	 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
 	if(allValues.size() == 0){			
            _bw.write(_wl_block10Bytes, _wl_block10);
		} else {  
			for(i=0; i<allValues.size(); i++){
			   existing_details = (String[])allValues.get(i);
		       if(existing_details[0] == null) existing_details[0] = "";
		       if(existing_details[1] == null) existing_details[1] = "";
			   if(existing_details[3] == null) existing_details[3] = "";
				if(existing_details[3].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])existing_details[3].split("!~!");
					String order_detail ="";
					String[] strtitle = null;
					for(int s=0;s<str.length;s++)
					{
						if(str[s].indexOf("$$RD##")!=-1)
						{
							String line_order = (String)str[s];
							strtitle  =line_order.split("::");
							String titleText = "";
							if(strtitle[1].length()>0)
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
							}
							else
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
							}
							strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
							order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
						}
						else
						{
							order_detail = order_detail+str[s]+", ";
						}
					}
					existing_details[3] = order_detail;
					if(existing_details[3].lastIndexOf(",") ==((existing_details[3].length())-2))
					{
						existing_details[3] = existing_details[3] .substring(0,((existing_details[3].length())-2));
					}
				}
				if(existing_details[3].indexOf("!~!")!=-1)
				{
					existing_details[3] = existing_details[3].replace("!~!",",");
				}
			   if(existing_details[9] == null) existing_details[9] = "";if(existing_details[11] == null) existing_details[11] = "";
			   if((view_by.trim()).equals("L")){
					order_line_num = existing_details[11];
			   } else  {
					order_line_num = "";
			   }
 			   query_executable_name		= executable_name+"&order_cat="+existing_details[0]+"&order_cat_desc="+existing_details[1]+"&line_order_id="+existing_details[9]+"&order_line_num="+order_line_num;
   			   if(!order_grouping_category.equals(existing_details[0])) {

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block16Bytes, _wl_block16);
				} else {  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block16Bytes, _wl_block16);
				} 
				order_grouping_category = existing_details[0]; 
 			} // End of For
	  } 
 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(executable_name));
            _bw.write(_wl_block22Bytes, _wl_block22);

	//putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
