package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eSS.Common.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __changebinlocationfortrayvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/ChangeBinLocationForTrayValidate.jsp", 1732510553876L ,"10.3.6.0","Asia/Calcutta")) return true;
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String bean_id = "changeBinLocationForTrayBean";
	String bean_name = "eSS.ChangeBinLocationForTrayBean";
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	
	ChangeBinLocationForTrayBean bean = (ChangeBinLocationForTrayBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String owner_store_code = (String) hash.get("owner_store_code");
				if (owner_store_code.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				bean.setOwner_store_code(owner_store_code);
				out.println("clearListItems('formChangeBinLocationForTrayQueryCriteria.bin_location_code'); ");
				out.println("clearListItems('formChangeBinLocationForTrayQueryCriteria.new_bin_location_code'); ");
				ArrayList alparams	= new ArrayList();
				alparams.add(owner_store_code);
				alparams.add(bean.getLanguageId());
				
				ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alparams);

				for (int i=0; i<alRecords.size(); i++){
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					out.println(  "addListItem(\"formChangeBinLocationForTrayQueryCriteria.bin_location_code\",\""+hmRecord.get("BIN_LOCATION_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
					out.println(  "addListItem(\"formChangeBinLocationForTrayQueryCriteria.new_bin_location_code\",\""+hmRecord.get("BIN_LOCATION_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
					}
				
		}
		break;
	
	case 2:
		{
		String owner_store_code				= request.getParameter("owner_store_code");
		String bin_location_code			= request.getParameter("bin_location_code" );
		String tray_no						= request.getParameter( "tray_no");
		String group_code					= request.getParameter("group_code");
		String new_bin_location_code		= request.getParameter("new_bin_location_code");
		String new_bin_location_desc		= request.getParameter("new_bin_location_desc");
		String doc_type_code				= request.getParameter("doc_type_code");
		String doc_no						= request.getParameter("doc_no");
		String locale						= request.getParameter("locale");
		owner_store_code					= CommonBean.checkForNull(owner_store_code,"%");
		//bean.setOwner_store_code(owner_store_code);
		bin_location_code					= CommonBean.checkForNull(bin_location_code,"%");
		bean.setNew_bin_location_code(new_bin_location_code);
		bean.setNew_bin_location_desc(new_bin_location_desc);
		group_code							=	CommonBean.checkForNull(group_code,"%");
		//bean.setGroup_code(group_code);
		tray_no								= CommonBean.checkForNull(tray_no,"%");
		doc_type_code						= CommonBean.checkForNull(doc_type_code,"%");
		doc_no								= CommonBean.checkForNull(doc_no,"%");

		bean.loadResultPage(new_bin_location_code,new_bin_location_desc,owner_store_code,bin_location_code,group_code,tray_no,doc_type_code,doc_no,locale);
		
		}
		break;

	case 3:
		{
			String index				=	request.getParameter("index");
			String new_bin_location_code			=	request.getParameter("new_bin_location_code");
			String new_bin_location_code_desc			=	request.getParameter("new_bin_location_code_desc");

			ArrayList result=(ArrayList)bean.getResultList();
			HashMap hmListItems	=	(HashMap)result.get(Integer.parseInt(index));
					out.println(hmListItems);
					hmListItems.put("NEW_BIN_LOCATION",		new_bin_location_code);
					hmListItems.put("NEW_BIN_LOCATION_DESC",		new_bin_location_code_desc);
					result.set(Integer.parseInt(index),hmListItems);
			
					out.println(result);
		}
	break;

	default :
		out.println("alert(\'Invalid Function\');");
		return;
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
