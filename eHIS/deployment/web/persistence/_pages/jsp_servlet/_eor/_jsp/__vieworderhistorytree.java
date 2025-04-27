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

public final class __vieworderhistorytree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewOrderHistoryTree.jsp", 1709120066000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\n<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eOR/html/ORMainMenu.css\"></link>-->\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ORMainMenu.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  \t<script>\n\tfunction dummy(){\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<FORM METHOD=POST ACTION=\"\" name=\"frmMenu\" id=\"frmMenu\">\n<script>\n\tvar obj;\n\tobj = new dTree(\'obj\');\n\tobj.add(0,-1,\'<font size=1 style=font-weight:bold style=color:#333><a class=\"gridLink\" href=\"#\" onClick=\"showHistoryResults()\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a></font>\');\n\tobj.config.useStatusText=true;\n\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"COMMON\"));\n\t\tparent.window.close();\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t \t\t\t\t\t\t\n\n\t\t\tobj.add(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="1\",\"0\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"\",\"\",\"\",\"\");\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\n\t\t\t\tvar temp_orderdetails2=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tif(temp_orderdetails2==\"ORDER_LINE_STATUS\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.OrderStatus.label\",\"common\");\n\t\t\t\telse if(temp_orderdetails2==\"QTY_VALUE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.Qty.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"QTY_UNIT\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.QtyUnit.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"ROUTE_CODE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.Route.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"FREQ_CODE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.Frequency.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"DURN_VALUE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.duration.label\",\"common\");\n\t\t\t\telse if(temp_orderdetails2==\"DURN_TYPE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.DurationType.label\",\"common\");\n\t\t\t\telse if(temp_orderdetails2==\"ITEM_NARRATION\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"eOR.ItemNarration.label\",\"OR\");\n\t\t\t\telse if(temp_orderdetails2==\"START_DATE_TIME\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.startdatetime.label\",\"common\");\n\t\t\t\telse if(temp_orderdetails2==\"END_DATE_TIME\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.enddatetime.label\",\"common\");\n\t\t\t\telse if(temp_orderdetails2==\"ORDER_CATALOG_CODE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.ordercatalog.label\",\"common\");\n\t\t\t\telse if(temp_orderdetails2==\"IV_PREP_YN\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"eOR.IVPrep.label\",\"OR\");\n\t\t\t\telse if(temp_orderdetails2==\"NUM_OF_REFILLS\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"eOR.NoOfRefills.label\",\"OR\");\n\t\t\t\telse if(temp_orderdetails2==\"PERFORM_DEPTLOC_CODE\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.PerformingLocation.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"SPECIMEN_DTLS\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.SpecimenDetails.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"RESULT_REVIEW\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"eCA.ReviewResults.label\",\"CA\");\n\t\t\t\telse if(temp_orderdetails2==\"CONSENT_DTLS\")\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"Common.ConsentDetails.label\",\"COMMON\");\n\t\t\t\telse if(temp_orderdetails2==\"RESULT_VIEW\")//IN062669\n\t\t\t\t\ttemp_orderdetails2=getLabel(\"eOR.ResultsViewed.label\",\"OR\");//IN062669\n\t\t\t\t\n\t\t\t\t obj.add(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="1\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="1\",temp_orderdetails2,\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"\",\"\",\"\",\"\");\n\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</script>\n\t<input type=\"hidden\" name=\"txtNodePoistions\" id=\"txtNodePoistions\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n \t<input type=\"hidden\" name=\"txtCurrentPosition\" id=\"txtCurrentPosition\" value=\"\">\n\t<input type=\"hidden\" name=\"txtToolTips\" id=\"txtToolTips\" value=\"\">\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<script>\n \t\tdocument.write(obj);\n\t\tobj.openAll();\n   \t\tparent.ViewOrderHistoryResult.location.href=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n  \t</script>\n\n </form>\n</body>\n</html>\n\n";
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
------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------
22/12/2016	IN062669     Vijayakumar K									ML-MMOH-CRF-0728 [IN:062669]
28/06/2018	IN065341     Prakash C		29/06/2018	Ramesh G	MMS-DM-CRF-0115
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	

	/* Mandatory checks start */
	//String mode					= "1";//request.getParameter( "mode" ) ;
 	String bean_id				= request.getParameter( "bean_id" ) ;
	String bean_name			= request.getParameter( "bean_name" ) ;
 
	//	ArrayList allValues = new ArrayList();
	/* Mandatory checks end */

	/* Initialize Function specific start */
 	//ViewOrder bean				= (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 ViewOrder bean					= (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(localeName);

	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	//bean.setMode( mode ) ;
	//String patient_id			= bean.checkForNull(request.getParameter("patient_id"));
 	String orderId				= bean.checkForNull(request.getParameter("orderId"));
 	String order_catalog_code	= request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");//IN061961
	String order_line_num		= request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");//IN061961
	String ord_cat		= request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");//IN061961
	String order_category		= request.getParameter("order_category")==null?"":request.getParameter("order_category");//IN061961
	String view_by		= request.getParameter("view_by")==null?"":request.getParameter("view_by");//IN061961
	boolean isviewLineDtls = bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
	String executable_name		= "../../eOR/jsp/ViewOrderHistoryResults.jsp?"+request.getQueryString();
	String workAreaFrame		= "ViewOrderHistoryResult";
	String query_executable_name= "";
//IN065341 starts
	String RepDb		= request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	//ArrayList catalogDetails	= bean.getOrderCatalogDetails(orderId,RepDb);
//IN065341 ends	//COMMENTED FOR IN061961
//	ArrayList catalogDetails	= bean.getOrderCatalogDetails(orderId,RepDb,order_catalog_code,view_by);//IN061961
	ArrayList catalogDetails	= bean.getOrderCatalogDetails(orderId,RepDb,order_catalog_code,view_by,order_category);//IN061961
	ArrayList orderDetails		= null;
	String[] catalog_details	= null;
	String[] order_details		= null;
	int i						= 0;
	String catalog_code			= "", catalog_desc			= "";
	String field_mnemonic		= "";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block9Bytes, _wl_block9);
 	
	if(catalogDetails.size() == 0)
	{			

            _bw.write(_wl_block10Bytes, _wl_block10);
		
	} 
	else
	{  
		for(i=0; i<catalogDetails.size(); i++)
		{
			catalog_details		= (String[])catalogDetails.get(i);
			catalog_code		= bean.checkForNull(catalog_details[0]);
			catalog_desc		= bean.checkForNull(catalog_details[1]);
			order_line_num		= bean.checkForNull(catalog_details[2]);
		//IN065341 starts
			//orderDetails		= bean.getOrderHistoryDetails(orderId, order_line_num);
			orderDetails		= bean.getOrderHistoryDetails(orderId, order_line_num,RepDb);
		//IN065341 ends		
			//query_executable_name = executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId;
			query_executable_name = executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId+"&view_by="+view_by+"&ind_order_line_num="+order_line_num;//IN061961

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block14Bytes, _wl_block14);

			for(int j=0; j<orderDetails.size(); j++)
			{
				 order_details			= (String[])orderDetails.get(j);
				 field_mnemonic			= bean.checkForNull(order_details[0]);
				 //query_executable_name	=  executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic;
				 query_executable_name	=  executable_name+"&order_cat=''&order_cat_desc="+catalog_desc+"&orderId="+orderId+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&ind_order_line_num="+order_line_num;//IN061961

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean.checkForNull(order_details[2])));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderId));
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean.checkForNull(order_details[2])));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block19Bytes, _wl_block19);
				} // End of for j
			} // End of for i 
	} // End of else
 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(executable_name));
            _bw.write(_wl_block23Bytes, _wl_block23);

	//putObjectInBean(bean_id,bean,request);

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
