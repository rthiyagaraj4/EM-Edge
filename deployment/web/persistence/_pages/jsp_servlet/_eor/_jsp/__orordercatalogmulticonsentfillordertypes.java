package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.Common.*;
import eOR.*;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orordercatalogmulticonsentfillordertypes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OROrderCatalogMultiConsentFillOrderTypes.jsp", 1716870882000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	OrderCatalogMultiConsent  beanObj = (OrderCatalogMultiConsent)getBeanObject( bean_id , bean_name, request) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	
		String queryMode = (String) hash.get("QUERYMODE");
		if(null!=queryMode && queryMode.equalsIgnoreCase("test"))
		{
			String order_category_id = (String)hash.get("order_category") ;
			out.println("clearOCMultiConsentOrderType('document');");

			ArrayList orderTypeData = (ArrayList)beanObj.getOrderTypes(order_category_id) ;
			String[] record =null;
			for( int i=0 ; i< orderTypeData.size() ; i++ ) 
			{
				record = (String[])orderTypeData.get(i);
				out.println( "addorderTypeData2List(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
			orderTypeData=null;
		}
		else if(null!=queryMode && queryMode.equalsIgnoreCase("search"))
		{
			String order_category_id = (String)hash.get("order_category") ;
			String orderType = (String) hash.get("order_type");
			String catalogue = (String) hash.get("order_catalog");
			String defSelected = (String) hash.get("definitionSelected");
			String recordCheck = (String) hash.get("recordCheck");//Added By  Channaveer B for issue number:IN21403
			ArrayList cataloguesData = (ArrayList)beanObj.getCatalogues(order_category_id,orderType,catalogue,defSelected) ;
			
			if(cataloguesData.size()==0)
			{
				//out.println("loadResultFrame('"+cataloguesData.size()+"')");
				out.println("recordsNotFound('document')");
				if(recordCheck.equals("NO"))////Added By  Channaveer B for issue number:IN21403
				{
				out.println("alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"))");
				}
				cataloguesData = null;
			}
			else
			{
				beanObj.setCatalogues_data(cataloguesData);
				//session.setAttribute("CATALOGUES_DATA",cataloguesData);
				out.println("loadResultFrame()");
			}
		}
		else if(null!=queryMode && queryMode.equalsIgnoreCase("sort"))
		{
			int totalRecords = (Integer.parseInt((String)hash.get("totalRecords"))) ;
			String[] catalogueInfo = null;
			ArrayList catalogueDetails = new ArrayList();
			String consentDesc = "";
			String consentID = "";
			String consentStage = "";
			String dfltSelected = "";
			String tempConsentDesc = "";
			String sequenceNumber = "";
			String select = "";
			for(int i=0;i<totalRecords;i++)
			{
				catalogueInfo = new String[7];
				consentDesc = (String) hash.get("consent_desc"+i);
				consentID = (String) hash.get("consent_form_id"+i);
				consentStage = (String) hash.get("consent_stage"+i);
				dfltSelected = (String) hash.get("mandatory"+i);
				sequenceNumber = (String) hash.get("seq_no"+i);
				tempConsentDesc = (String) hash.get("temp_consent_desc"+i);
				select = (String) hash.get("select"+i);
				catalogueInfo[0] = consentDesc;
				catalogueInfo[1] = consentID;
				catalogueInfo[2] = consentStage;
				catalogueInfo[3] = dfltSelected;
				catalogueInfo[4] = sequenceNumber;
				if(consentDesc.equalsIgnoreCase(tempConsentDesc))
				{
					catalogueInfo[5] = tempConsentDesc;
				}
				else
				{
					catalogueInfo[5] = "";
				}
				catalogueInfo[6] = select;
				catalogueDetails.add(catalogueInfo);
				beanObj.setCatalog_details(catalogueDetails);
				//session.setAttribute("CATALOGUES_DETAILS",catalogueDetails);
			}
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
