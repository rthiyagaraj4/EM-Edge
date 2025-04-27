package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import eOR.Common.*;
import ePH.*;
import eBL.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blinsuranceapprdrugsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInsuranceApprDrugsValidate.jsp", 1716198725165L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);


    Hashtable hash				= (Hashtable)xmlObj.parseXMLString(request) ;
	String bean_id   = "@BLInsuranceApprDrugsBean" ;
	String bean_name = "eBL.BLInsuranceApprDrugsBean";
	BLInsuranceApprDrugsBean bean			= (BLInsuranceApprDrugsBean)getBeanObject( bean_id, bean_name, request);
	ArrayList DrugList = new ArrayList(bean.getOrderSatList());
	//System.err.println("DrugList:"+DrugList);
	HashMap sel_drug_list = (HashMap) session.getAttribute("sel_drug_list");
	if(sel_drug_list == null) sel_drug_list = new HashMap();
	
	String drugCode= (String)request.getParameter("drugCode")==null?"":(String)request.getParameter("drugCode");
	String sel_drug_desc = (String)request.getParameter("drugDesc")==null?"":(String)request.getParameter("drugDesc");
	
	String apprYN =   (String)request.getParameter("apprYN")==null?"":(String)request.getParameter("apprYN");
	String IPYN = (String)request.getParameter("IPYN")==null?"":(String)request.getParameter("IPYN");
	String DCYN = (String)request.getParameter("DCYN")==null?"":(String)request.getParameter("DCYN");
	String OPYN = (String)request.getParameter("OPYN")==null?"":(String)request.getParameter("OPYN");
	String EMYN = (String)request.getParameter("EMYN")==null?"":(String)request.getParameter("EMYN");
	String ALLYN = (String)request.getParameter("ALLYN")==null?"":(String)request.getParameter("ALLYN");
	String ApprAllYN = (String)request.getParameter("apprAllYN")==null?"N":(String)request.getParameter("apprAllYN");	
	
	String form_mode = (String)request.getParameter("form_mode")==null?"":(String)request.getParameter("form_mode");
	
	String calledFrm = (String)request.getParameter("calledFrm")==null?"":(String)request.getParameter("calledFrm");
	
	System.err.println("form_mode:"+form_mode);
	System.err.println("drugCode:"+drugCode);
	System.err.println("sel_drug_desc:"+sel_drug_desc);
	System.err.println("apprYN:"+apprYN);
	System.err.println("IPYN:"+IPYN);
	System.err.println("DCYN:"+DCYN);
	System.err.println("OPYN:"+OPYN);
	System.err.println("EMYN:"+EMYN);
	System.err.println("ALLYN:"+ALLYN);
	System.err.println("ApprAllYN:"+ApprAllYN);
	System.err.println("DrugList.size():"+DrugList.size());
	try
	{
		if("Q".equals(calledFrm)){
			for(int i=0; i<DrugList.size()-1; i++){
				if("Y".equals((String)DrugList.get(i+2)) || "Y".equals((String)DrugList.get(i+3)) || "Y".equals((String)DrugList.get(i+4)) || "Y".equals((String)DrugList.get(i+5)) || "Y".equals((String)DrugList.get(i+6)) || "Y".equals((String)DrugList.get(i+7)))
				{
					sel_drug_list.put(((String)DrugList.get(i)),((String)DrugList.get(i))+"~"+((String)DrugList.get(i+1))+"~"+((String)DrugList.get(i+2))+"~"+((String)DrugList.get(i+3))+"~"+((String)DrugList.get(i+4))+"~"+((String)DrugList.get(i+5))+"~"+((String)DrugList.get(i+6))+"~"+((String)DrugList.get(i+7)));
					
					//System.err.println("i:"+i);
				}
				i = i+7;
			}
		}
		else
		{
			if(form_mode.equals("apprChk") || form_mode.equals("IP") || form_mode.equals("DC") || form_mode.equals("OP") || form_mode.equals("EM") || form_mode.equals("ALL")){
				if(!drugCode.equals("")){
					for(int i=0; i<DrugList.size(); i++){				
						if(((String)DrugList.get(i)).trim().equals(drugCode.trim())){
							DrugList.set(i+2,apprYN);
							DrugList.set(i+3,IPYN);
							DrugList.set(i+4,DCYN);
							DrugList.set(i+5,OPYN);
							DrugList.set(i+6,EMYN);
							DrugList.set(i+7,ALLYN);						
							sel_drug_list.put(drugCode,drugCode+"~"+sel_drug_desc+"~"+apprYN+"~"+IPYN+"~"+DCYN+"~"+OPYN+"~"+EMYN+"~"+ALLYN);
							break;
						}				
					}
				}
			}		
			
			if(form_mode.equals("ApprAllDrugs")){
					if("Y".equals(ApprAllYN)){
						for(int i=0; i<DrugList.size()-1; i++){
							DrugList.set(i+2,"Y");
							sel_drug_list.put(DrugList.get(i),DrugList.get(i)+"~"+DrugList.get(i+1)+"~"+"Y"+"~"+DrugList.get(i+3)+"~"+DrugList.get(i+4)+"~"+DrugList.get(i+5)+"~"+DrugList.get(i+6)+"~"+DrugList.get(i+7));
							i = i+7;
						}
					} else {
						for(int i=0; i<DrugList.size()-1; i++){
							DrugList.set(i+2,"N");
							sel_drug_list.put(DrugList.get(i),DrugList.get(i)+"~"+DrugList.get(i+1)+"~"+"N"+"~"+DrugList.get(i+3)+"~"+DrugList.get(i+4)+"~"+DrugList.get(i+5)+"~"+DrugList.get(i+6)+"~"+DrugList.get(i+7));
							i = i+7;
						}				
					}
			}
		}
		//System.err.println("DrugList:"+DrugList);
		bean.setOrderSatList(DrugList);
		bean.setSelectedInsApprdDrugs(sel_drug_list);
		session.setAttribute("sel_drug_list",sel_drug_list);
		HashMap hm = new HashMap(bean.getSelectedInsApprdDrugs());
		System.err.println("hm.setAttribute:"+hm);
	}catch (Exception e){
		System.err.println("Exception in BLInsuranceApprDrugsValidate.jsp:"+e);
	}

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
