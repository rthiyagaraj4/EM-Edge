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

public final class __tpnconsnsregimenvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TpnConsNsRegimenValidate.jsp", 1721996155626L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);

	Hashtable hash	= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash			= (Hashtable)hash.get( "SEARCH" ) ;
	ArrayList prscontvalue= new ArrayList();	
	String prscontvalueUOM = "";
	ArrayList 	pressUom = new ArrayList();
	ArrayList 	loadPressUom = new ArrayList();
	String bean_id	=	"TPNConsNSRegimenBean"; 
	String bean_name=	"ePH.TPNConsNSRegimenBean";
	TPNConsNSRegimenBean bean = (TPNConsNSRegimenBean)getBeanObject( bean_id, bean_name,request) ;
	String identity = request.getParameter("identity");
	
	

	if(identity.equals("getcontPresbaseUOM")){
		String item_code = (String)hash.get("item_code");
		String const_generic_code = (String)hash.get("const_generic_code");

		pressUom =	bean.getcontPrssUOM(item_code,const_generic_code);
		
		for(int i=0;i<pressUom.size();i++) {
		prscontvalueUOM =(String) pressUom.get(i);
		}

		if (prscontvalueUOM == null ||  prscontvalueUOM.equals("") ) {
		prscontvalueUOM="";
		}
	
/*
	for(int i=0;i<pressUom.size();i=i+2) {
		if(pressUom.get(i).equals(item_code)) {
		out.println("alert('inside the if condition in interm jsp .. ')");
		prscontvalue = (String) pressUom.get(i+1);
		}
	}*/
	out.println("assigncontPresbaseUOM('"+prscontvalueUOM+"')");
	}
else if(identity.equals("loadcontPresUOM")){

		String item_code = (String)hash.get("item_code");
		String const_generic_code = (String)hash.get("const_generic_code");

		out.println("alert('"+item_code+"')");
		out.println("alert('"+const_generic_code+"')");

//		bean.loadContPrssUOM(item_code,const_generic_code);
		loadPressUom =	bean.loadContPrssUOM(item_code,const_generic_code);
			
/*		for(int i=0;i<loadPressUom.size();i++) {
		StrprscontvalueUOM =(String) loadPressUom.get(i);
		}
*/
	}

	else if(identity.equals("getStockUOM")){
		String item_code = (String)hash.get("item_code");
		out.println("assignSaleUOMCode('"+bean.getSaleUOMCode(item_code)+"')");
	}else if(identity.equals("getGroupCode")){
		String generic_code = (String)hash.get("generic_code");
		out.println(bean.getGroupCode(generic_code));
	}else if(identity.equals("getContentInPresBaseUOM")){
		String item_code	= (String)hash.get("item_code");
		//String generic_code = (String)hash.get("generic_code");
		String item_stock_uom = (String)hash.get("item_stock_uom");

		String 	stmval=	bean.getContentInPresBaseUOM(item_stock_uom);
//		out.println("assignContentInPresBaseUOM('"+bean.getContentInPresBaseUOM(item_stock_uom)+"')");
		out.println("assignContentInPresBaseUOM('"+stmval+"')");

	}
	else if(identity.equals("getOsmolarValue")){
		String item_code	= (String)hash.get("item_code");
		String osmolar_value = (String)hash.get("osmolar_value");		
		String molecule_value = (String)hash.get("molecule_value");		
		String molecule_code = (String)hash.get("molecule_code");	
		String pres_base_uom = (String)hash.get("pres_base_uom");	
		String concentration = (String)hash.get("item_concentration");//Added for ML-MMOH-CRF-1201
        String volume = (String)hash.get("volume");//Added for ML-MMOH-CRF-1201
		String locale = bean.getLanguageId();//Added for ML-MMOH-CRF-1201

	 ArrayList  osmol_val =	new ArrayList();
     osmol_val = bean.getOsmolar();
	
/*
	for(int i=0;i<osmol_val.size();i=i+2) {
		if(osmol_val.get(i).equals(item_code)) {
		osmol_val.set(i+1,osmolar_value);	
		}

*/
		for(int i=0;i<osmol_val.size();i=i+6) {//Changed 4 to 6 for ML-MMOH-CRF-1201
		if(osmol_val.get(i).equals(item_code)) {
		osmol_val.set(i+1,osmolar_value);	
		osmol_val.set(i+2,molecule_code);	
		osmol_val.set(i+3,pres_base_uom);
		osmol_val.set(i+4,concentration);//Added for ML-MMOH-CRF-1201
		osmol_val.set(i+5,volume);//Added for ML-MMOH-CRF-1201
		}

		else{
			osmol_val.add(item_code);
			osmol_val.add(osmolar_value);
			osmol_val.add(molecule_code);
			osmol_val.add(pres_base_uom);
			osmol_val.add(concentration);//Added for ML-MMOH-CRF-1201
			osmol_val.add(volume);//Added for ML-MMOH-CRF-1201
		}
	}

	/*
		if(!osmol_val.contains(item_code)) {
			osmol_val.add(item_code);
			osmol_val.add(osmolar_value);
		}
	*/

   bean.setOsmolar(osmol_val);
//Adding start for ML-MMOH-CRF-1201
  HashMap map_applicable=bean.getApplicabulityMap();
  System.err.println("map_applicable@@@@==="+map_applicable+"item_code==="+item_code+"locale=="+locale);
  if(!map_applicable.containsKey(item_code)){
	  bean.getAgeGroupsNS(locale,item_code);
  }//Adding end for ML-MMOH-CRF-1201
  }//added for ml-mmoh-crf-1201 start
  else if ( identity.equals( "applicable_ok_cancel" ) ) {		
	  String action_type = (String)hash.get("action_type");
	  HashMap  map = bean.getApplicabulityMap();
	  if (action_type.equals("OK")){
	  String drug_code=(String)hash.get("drug_code");
	  int count=Integer.parseInt((String)hash.get("count"));
	  
	  String param="code";
	   String param1="value";
	  String code="";
	  String value="";
	  if (map.containsKey(drug_code)){
		  HashMap  map1 = (HashMap)map.get(drug_code);  
	      for(int i=0;i<count;i++){
	    	   param="code"+i;
	   	       param1="value"+i;
	    	  code=(String)hash.get(param);
	    	   value=(String)hash.get(param1);
	    	  map1.put(code, value);  
	    	 
	      }
	     
	      map.put(drug_code,map1);
	    
	  }
	  }  
	  
	  bean.setApplicabulityMap(map);
	 
  }

            _bw.write(_wl_block0Bytes, _wl_block0);
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
