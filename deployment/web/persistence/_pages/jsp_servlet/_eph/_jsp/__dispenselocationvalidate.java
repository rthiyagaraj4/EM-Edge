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

public final class __dispenselocationvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispenseLocationValidate.jsp", 1721649661306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
	//String locale			= (String)session.getAttribute("LOCALE");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	
	String objname = request.getParameter( "object" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	DispenseLocationBean beanObj = ( DispenseLocationBean )getBeanObject( bean_id, bean_name,request ) ;

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "onlineprintlist" ) ) {
		
		
		String report_id	= (String)hash.get("report_id");
		String list_name	= (String)hash.get("list_name");
		String changed_value = (String)hash.get("changed_value");
		
          
		HashMap onlineMap	= beanObj.getOnlinePrintSetupMap();
		HashMap map			= (HashMap)onlineMap.get(report_id);
		beanObj.setToOnlinePrintMap(report_id+"~~"+list_name,map.get(list_name).toString());
		map.put(list_name,changed_value);
		onlineMap.put(report_id,map);
		beanObj.setOnlinePrintSetupMap(onlineMap);
	}

	if ( validate.equals( "onlineprintlist_ok_cancel" ) ) {		
		String action_type = request.getParameter("action_type");
		String select_all = (String)hash.get("select_all");		
     	HashMap  onlinePrintMap = beanObj.getOnlinePrintSetupMap(); //updated values are stored in this map
		HashMap  map = beanObj.getOnlinePrintMap();
		String select_all_prev = beanObj.getSelectAll();
		if (action_type.equals("cancel")){
			 //before changed values are stored in this map
			Set keys = map.keySet();
			String label_listname ="";
			String label ="";
		    String listName ="";
			for (Iterator i = keys.iterator(); i.hasNext();){
			label_listname = (String) i.next();
			StringTokenizer st =new StringTokenizer(label_listname,"~~");
			while (st.hasMoreTokens()){
			 label= st.nextToken();
			 listName= st.nextToken();
			 if (onlinePrintMap.containsKey(label)){
				 HashMap map1 = (HashMap)onlinePrintMap.get(label);
				 map1.put(listName,map.get(label_listname).toString());
				 onlinePrintMap.put(label,map1);
			 }
			}
			}
				beanObj.setSelectAll(select_all_prev); //previous select all value will be stored in the bean
		}
		else{
				beanObj.setSelectAll(select_all);
		}
		beanObj.setOnlinePrintSetupMap(onlinePrintMap);	
		map.clear();	

		}	

	if ( validate.equals( "DISP_LOCN_CODE" ) ) {
		String disp_locn_code = ( String )hash.get( objname ) ;
		if ( beanObj.validateCode(disp_locn_code, 1).equals("true") ) {
			out.println("callalert('DISP_LOCN_CODE');") ;
		}
	}

	if ( validate.equals( "STORE_CODE" ) ) {
		String store_code = ( String )hash.get( objname ) ;
		if ( beanObj.validateCode(store_code, 1).equals("true") ) {
			out.println("callalert('STORE_CODE');") ;
		}else{
			String retVal = beanObj.validateCode(store_code, 2) ;
			out.println("assignDescs('"+ store_code + "|" + retVal +"');") ;
		}
	}
	if ( validate.equals( "IP_DAILY_SQENCE_NO" ) )
		{
			String dsn_from =  (String)request.getParameter( "IP_SQE_NO_FROM" )==null?"":(String) request.getParameter( "IP_SQE_NO_FROM" );
			String dsn_to = (String)request.getParameter( "IP_SQE_NO_TO" )==null?"":(String) request.getParameter( "IP_SQE_NO_TO" );
			String disp_loc_code_modify = (String)request.getParameter( "DISP_LOCN_CODE" )==null?"":(String) request.getParameter( "DISP_LOCN_CODE" );
			if(!(dsn_from.equals("")) && !(dsn_to.equals("")))
				{
					int IP_SQE_NO_FROM =Integer.parseInt(dsn_from) ;
					int IP_SQE_NO_TO = Integer.parseInt(dsn_to) ;
		
				    boolean validRange= beanObj.getRangeOverlapValidate((ArrayList)beanObj.getDailySpecificRange(),IP_SQE_NO_FROM,IP_SQE_NO_TO,disp_loc_code_modify);
			
					 if(validRange)
						{
							out.println("callconform();") ;
						}
				}
		}

	if ( validate.equals( "saveRemarks" ) ) {

		String remarks_code			=	(String)hash.get("remarks");
		if(remarks_code.equals(""))
			remarks_code=beanObj.getRemarksCode()==null?"":beanObj.getRemarksCode();

		String reason_desc			=java.net.URLDecoder.decode((String)hash.get("remarks_desc"));
		String remarks_desc			=	beanObj.getRemarksDescription(remarks_code)==null?"":beanObj.getRemarksDescription(remarks_code);
		beanObj.setRemarksCode(remarks_code);
		beanObj.setReasonDesc(reason_desc);
		beanObj.setRemarksDesc(remarks_desc);


	}
	if ( validate.equals( "saveRemark" ) ) {
		String remarks_code			 = (String)hash.get("remarks");
		if(remarks_code.equals(""))
			remarks_code=beanObj.getRemarksCode()==null?"":beanObj.getRemarksCode();
		String reason_desc		=java.net.URLDecoder.decode((String)hash.get("remarks_desc"));
		String remarks_desc =beanObj.getRemarksDescription(remarks_code)==null?"":beanObj.getRemarksDescription(remarks_code);				
			remarks_desc=java.net.URLEncoder.encode(remarks_desc);	
		out.println("assignRemarksDescs('"+ remarks_desc + "');") ;
	}
	

            _bw.write(_wl_block2Bytes, _wl_block2);

putObjectInBean(bean_id,beanObj,request);

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
