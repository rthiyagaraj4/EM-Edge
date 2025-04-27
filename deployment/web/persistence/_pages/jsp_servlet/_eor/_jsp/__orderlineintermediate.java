package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eOR.Common.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderlineintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderLineIntermediate.jsp", 1732685302000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
17/02/2014	  IN024984		Karthi		21/02/2014			Ramesh			Conditional reordering by clinician
28/02/2014	  IN047320		Karthi		28/02/2014			Ramesh			In RD module, the duplicate reason captured (while placing an duplicate order in CA) is not getting displayed in the screen
10/03/2014	  IN024984		Chowminya										Duplicate order recording with reason - new mandatory option	
12/03/2014    IN047621		Chowminya										Space in Dup override reason text allowed
14/03/2014	  IN047637		Karthi							  				System allowing to Reorder multi orders without entering duplicate reason
18/03/2014	  IN047867		Karthi							  				By deleting the entered Override reason is not updated.
21/10/2015	  IN057196		Ramesh G								Recording Of Consent Form
03/07/2017    IN062607		Raja S		03/07/2017		Ramesh G			ML-MMOH-CRF-0727
17/02/2020	  IN071260		Nijitha S	17/02/2020		Ramesh G	MMS-KH-CRF-0029.3
29/02/2020	  IN072592		Nijitha S	29/02/2020		Ramesh G	OR-MMS-KH-CRF-0029.3/03-Place order 
06/07/2020	  IN072654		Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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
	
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ; //Check Style Unused local variable
	//String locale = (String) p.getProperty("LOCALE"); //Check Style Unused local variable
	try{
		Hashtable hashObj 			 = (Hashtable)XMLobj.parseXMLString(request);
 		hashObj 					 = (Hashtable)hashObj.get("SEARCH");
		String l_bean_id 			 = (String)hashObj.get("p_bean_id");
		String l_bean_name 			 = (String)hashObj.get("p_bean_name");
		String l_action 			 = (String)hashObj.get("p_action") == null?"":(String)hashObj.get("p_action");
		String l_firstDupWin 			 = (String)hashObj.get("p_fdupwin") == null?"N":(String)hashObj.get("p_fdupwin");//Added for IN062607
		HashMap l_setDupeOrderReason = null;		
		OrderEntryBean beanObj = (OrderEntryBean)getBeanObject(l_bean_id, l_bean_name, request);
		if(l_action.equalsIgnoreCase("DUPLICATE_ORDER_REASON"))  {
			String l_catalog_code				= (String)hashObj.get("p_catalog_code")== null?"": (String)hashObj.get("p_catalog_code");
			String l_dupe_override_remarks		= (String)hashObj.get("p_dupe_override_remarks")== null?"": (String)hashObj.get("p_dupe_override_remarks");
			l_dupe_override_remarks = l_dupe_override_remarks.trim();//IN047621
			//if(!"".equals(l_dupe_override_remarks)) { // added for IN047687
				l_setDupeOrderReason = beanObj.setDupeCodeRemarks(l_catalog_code, l_dupe_override_remarks);
			//}	// added for IN047687
		}
		else if(l_action.equalsIgnoreCase("DUPLICATE_REASON_VALIDATION"))  {
			String l_dupe_override_remarks		= (String)hashObj.get("p_dupe_common_remarks")== null?"": (String)hashObj.get("p_dupe_common_remarks");
			l_dupe_override_remarks = l_dupe_override_remarks.trim();//IN047621
			//l_dupe_override_remarks = java.net.URLDecoder.decode(l_dupe_override_remarks,"UTF-8");//IN047605
			String dupe_catalog_code_list = (String)hashObj.get("p_dupe_catalog_list")== null?"": (String)hashObj.get("p_dupe_catalog_list");
			HashMap  l_hashMap =	beanObj.getDupeReasonHashMap();		
			StringTokenizer st = new StringTokenizer(dupe_catalog_code_list,"#");
			// Code below modified for IN047320 - Start
			String l_key  = "";
			String mandate_key = "N";//IN024984
			boolean isReasonExists = false; // IN047637
			beanObj.setTempDupeCodeRemarks(l_dupe_override_remarks);//IN062607
			if(l_hashMap != null && l_hashMap.size()>0){
				
				while(st.hasMoreElements()){
					l_key = (String)st.nextElement();
					// IN047637 - Start
					mandate_key = (String)st.nextElement();
					if( mandate_key.equals("Y") && l_dupe_override_remarks.equals("")) {
						isReasonExists = beanObj.isDupeReasonExists(l_key); 
						if(isReasonExists == false) {
							out.println("validatedHashMap(\"" +l_key + "\"); ");
						}	
					}
					// IN047637 - End
					if((String)l_hashMap.get(l_key) == null || "".equals((String)l_hashMap.get(l_key))) {
						if("N".equals(l_firstDupWin))//Added for IN062607
						l_hashMap.put(l_key, l_dupe_override_remarks);
					}
				}	
			}		
			else{
				while(st.hasMoreElements()){
					l_key = (String)st.nextElement();
					mandate_key = (String)st.nextElement();//IN024984
					if(l_dupe_override_remarks.equals("") && mandate_key.equals("Y")) {
						out.println("validatedHashMap(\"" +l_key + "\"); ");
					}
					else{
						if("N".equals(l_firstDupWin))//Added for IN062607	
						beanObj.setDupeCodeRemarks(l_key, l_dupe_override_remarks);
					}
				}	
			}
			// IN047320 - End
		}
		//IN057196 Start.
		else if(l_action.equalsIgnoreCase("RECORD_CONSENT_FORM_WITH_ORDER"))  {			
			out.println(beanObj.getRecordConsetFormWithOrderYN());			
		}
		////IN057196 End.
		//IN071260 Starts
		else if(l_action.equalsIgnoreCase("DRUG_OVERRIDE_REMARKS"))  {	
			OrderDrugInteractionVO drugDtls =null;
			String catalog_code ="";
			String overRemarks = "";
			ArrayList<OrderDrugInteractionVO> data=null;
			HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = beanObj.getDruginteractionDtl();
			if(null!=interdrugDtls){
				for (Map.Entry<String,ArrayList<OrderDrugInteractionVO>> drugs : interdrugDtls.entrySet())  
				{
					catalog_code = drugs.getKey();
					 data = drugs.getValue();
					if(null!=data){	
						for(int i=0;i<data.size();i++)
						{
							drugDtls = data.get(i);
							if(null!=drugDtls && null!=drugDtls.getDrugRestrictYN() && !"Y".equals(drugDtls.getDrugRestrictYN())){
								overRemarks = (String)hashObj.get("interOverRmks"+catalog_code+drugDtls.getDrugCode()+i)== null?"": (String)hashObj.get("interOverRmks"+catalog_code+drugDtls.getDrugCode()+i);	//	IN072654
								drugDtls.setOverrideRemarks(java.net.URLDecoder.decode(overRemarks,"UTF-8"));//	IN072654
								beanObj.setTempValues("drugOverrideRemarks"+catalog_code+drugDtls.getDrugCode(), java.net.URLDecoder.decode(overRemarks,"UTF-8"));//IN072592
							
							}
	
						}
					}
				}
			}
			out.println("success");
		}
	 	else if(l_action.equalsIgnoreCase("DRUG_INTERACTION_HIDE_UNHIDE"))  {	//IN072595 Starts
			
	 		OrderDrugInteractionVO drugDtls =null;
			String catalog_code	 = (String)hashObj.get("catalog_code");
			String catalog_chk_unchk	 = (String)hashObj.get("catalog_chk_unchk");
			
			HashMap<String, String> interdrugDtls = beanObj.getDruginteractionYN();
			if(null!=interdrugDtls){
				if("H".equals(catalog_chk_unchk))
					interdrugDtls.put(catalog_code, catalog_chk_unchk);
				else{
					interdrugDtls.put(catalog_code, catalog_chk_unchk);
				}
			}
		
		} //IN072595 Ends
		//IN071260 Ends
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println(" 45. OrderLineIntermediate.jsp = Message => " + ex.getMessage());
		
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
