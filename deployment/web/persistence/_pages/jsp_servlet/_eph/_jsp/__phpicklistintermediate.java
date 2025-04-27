package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

public final class __phpicklistintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PHPickListIntermediate.jsp", 1742387193126L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

	String bean_id			= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String dcode				= request.getParameter( "dispense_code" ) ;
	String function			=request.getParameter("function");
	ecis.utils.OnlineReports onlineReports		=	null;
	ecis.utils.OnlineReport report1				=	null;
	
	String scheduleStartTime1= null;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;

    PHPickListBean bean = (PHPickListBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	if(!function.equals("GENERATEFILLLIST") && !function.equals("assignAltDrug") && !function.equals("assignBtchDtls") && !function.equals("GENERATEPICKlIST")){
		bean.clear();
	}
	  if(function.equals("GENERATEPICKlIST")){ // Added by Himanshu For PickList on 17/03/2024 Against GHL-CRF-0672.1
		  
		  String patient_id			= request.getParameter( "patient_id" ) ;
			String arr_of_orders[]		= request.getParameterValues( "arr_of_orders" ) ;
			String facility_id				= request.getParameter( "facility_id" ) ;
			String Nursing_Unit_From_Code				= request.getParameter( "Nursing_Unit_From_Code" ) ;
			String pick_int_start_date_time				= request.getParameter( "fill_int_start_date_time" ) ;
			String pick_int_end_date_time				= request.getParameter( "fill_int_end_date_time" ) ;
			String disp_locn_code				= request.getParameter( "disp_locn_code" ) ;
			System.out.println("Nursing_Unit_From_Code"+Nursing_Unit_From_Code);
			System.out.println("fill_int_start_date_time"+pick_int_start_date_time);
			System.out.println("fill_int_end_date_time"+pick_int_end_date_time);
			String patArray = (String) hash.get( "patArray" );
			String orderArray = (String) hash.get( "orderArray" );
			String patient_orderdetail = (String) hash.get( "patient_orderdetail" );
			String formattedOrderIds="";
			System.out.println("fill_int_end_date_time2 "+pick_int_end_date_time);
			String arrpatorder[];
			StringTokenizer st1	 = new StringTokenizer(orderArray, ",");
			ArrayList selectOrder=new ArrayList();
				while (st1.hasMoreTokens())
				{
					selectOrder.add(st1.nextToken());
				}
			HashMap map = (HashMap)bean.updatepicklistFlag("", selectOrder,facility_id); 
			boolean result	= ((Boolean)map.get("result")).booleanValue();
			String message	= (String)map.get("message");
			String flag		= (String)map.get("flag");
			if(message==null) message		=	"";
			if(flag==null) flag		=	"";
			System.out.println(result);
			boolean flag1=false;
			System.out.println("arr_of_orders[0].toString()===> "+patient_orderdetail);
			
			arrpatorder = patient_orderdetail.toString().split("#");
			for(String pat_ord:arrpatorder)
			{
				if(!pat_ord.equals("")){
				arr_of_orders=pat_ord.split("@@@");
				String[] orderIds = arr_of_orders[1].split(",");
				StringBuilder orderIdBuilder = new StringBuilder();
				for (String orderId : orderIds) {
                    orderId = orderId.replace("'", "").trim();
                    orderIdBuilder.append("'");
                    orderIdBuilder.append(orderId);
                    orderIdBuilder.append("',");
                }
				 formattedOrderIds = orderIdBuilder.toString();
				 formattedOrderIds = formattedOrderIds.replaceAll(",$", "");
				 formattedOrderIds = formattedOrderIds.substring(1, formattedOrderIds.length() - 1);
				 flag1=bean.doPrinting(request,response,arr_of_orders[0].toString(),formattedOrderIds,pick_int_start_date_time,pick_int_end_date_time,disp_locn_code,Nursing_Unit_From_Code);
				}
			}
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\");");
		}
	  
	  

putObjectInBean(bean_id,bean,request);

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
