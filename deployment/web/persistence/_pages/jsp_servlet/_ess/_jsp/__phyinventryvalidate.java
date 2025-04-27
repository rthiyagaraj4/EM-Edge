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

public final class __phyinventryvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/PhyInvEntryValidate.jsp", 1732510752093L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	String bean_id			= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	int functionType		= Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;

	PhyInvEntryBean bean	= (PhyInvEntryBean)getBeanObject(bean_id, bean_name,request );
	Hashtable hash			= (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1: // case - 1 will be executed on focus lost of Store Code
		{
				
				String store_code = bean.getStore_code();
				
				if (store_code.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				bean.setStore_code(store_code);
				out.println("clearListItems('parent.PhyInvEntryDetailFrame.document.formPhyInvEntryDetail.bin_location_code'); ");
				ArrayList binLocation = bean.getBinLocationData(store_code);
				
				for(int i=0; i< binLocation.size(); i++) {
					String[] record = (String[])binLocation.get(i);
					out.println("addListItem(\"parent.PhyInvEntryDetailFrame.document.formPhyInvEntryDetail.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\"); ");
				}
			}
		break;
	case 2 :
		{
			String phy_inv_id = (String) hash.get("phy_inv_id");
			if (phy_inv_id == null) {
				return;
			}
			bean.setPhy_inv_id(phy_inv_id);
			boolean isValidPhyInvID = bean.isValidPhyInvID();
			if (isValidPhyInvID) {
				out.println("setCountSheetDate('"+bean.getCount_sheet_date()+"');");
			}
			out.println("assignResult("+isValidPhyInvID+",\"\", \"0\");");
		}
		break;
	case 3 :
		{
			String store_code = (String) hash.get("owner_store_code");
			String phy_inv_id = (String) hash.get("phy_inv_id");
			String curr_store_code = (String) hash.get("current_store_code");
			bean.setStore_code(store_code);
			bean.setPhy_inv_id(phy_inv_id);
			bean.setCurr_store_code(curr_store_code);
			boolean isValidPhyInvRecord = bean.isValidPhyInvRecord();
			out.println("assignResult("+isValidPhyInvRecord+",\"\", \"0\");");
		}
		break;
	case 4:
		//Update the bean values
		{
			java.util.HashMap hmResult= bean.updateTrayDetails(hash);
			boolean result = ((Boolean)hmResult.get("result")).booleanValue();
			String message = (String)hmResult.get("msgid");
			String flag = (String)hmResult.get("flag");
			out.println("assignResult(" + result + ", \"" + message + "\", \""+flag+"\" ) ; ") ;
		}
		break;
	case 5: // Validate Tray No
		{
				String store_code = (String) hash.get("owner_store_code");
				String group_code = (String) hash.get("group_code");
				String tray_no = (String) hash.get("tray_no");
				String current_store_code = (String) hash.get("current_store_code");
				String phy_inv_id = (String) hash.get("phy_inv_id");
				boolean isValidTrayNo = bean.trayNoExists(store_code,group_code,tray_no,current_store_code,phy_inv_id);
				if (isValidTrayNo && (!store_code.equals(current_store_code))) {
					out.println("setBinLocation('"+bean.getTemp_bin_location()+"');");
				}
				out.println("assignResult("+isValidTrayNo+",\"\", \"0\");");
				if (!isValidTrayNo) {
					return;
				}

		}
		break;
	case 6:
		//Update the selected tray values
		{
			bean.updateSelectedTrays(hash);
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
