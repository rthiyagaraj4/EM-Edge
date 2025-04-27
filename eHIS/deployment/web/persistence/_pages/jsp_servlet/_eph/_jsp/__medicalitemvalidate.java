package jsp_servlet._eph._jsp;

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
import ePH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __medicalitemvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicalItemValidate.jsp", 1732509518491L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String func_mode			= request.getParameter("func_mode");
    //String itemcode=""; 
	String	bean_trade_id					=	"";
	//String	select					=	"";
	String pres_base_uom="";
	String pres_base_uom_value="";
	String Drug_code="";
	String Drug_code_value="";
	String local="";
	String mode="";
	String eqvl_value="";
	boolean dup_found						=	false;
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	pres_base_uom		        = (String) hash.get( "pres_base_uom" );
	//String packSize		        = (String) hash.get( "packSize" );
	String stock_uom		    = (String) hash.get( "stock_uom" );
	pres_base_uom_value		    = (String) hash.get( "pres_base_uom_value" );
	Drug_code		            = (String) hash.get( "Drug_code" );
	Drug_code_value		        = (String) hash.get( "Drug_code_value" );
	local		            = (String) hash.get( "local" );
	String vaY		            = (String) hash.get( "vaY" )==null?"E":(String) hash.get( "vaY" );
    String code="";
    String desc="";
    MedicalItemBean bean		= (MedicalItemBean)getBeanObject(bean_id, bean_name, request);
	bean.setLanguageId(locale);
	if(pres_base_uom!= null)
	{
    out.println("DispensingUnitclear()");   
    out.println("DispensingUnitAssign()");   
	ArrayList DispensingUnitlist=new ArrayList(); 
    HashMap DispensingUnitValues=new HashMap();
	DispensingUnitlist=bean.getDispensingUnitrelated(pres_base_uom,locale);
	for(int i=0; i<DispensingUnitlist.size(); i++)
	 	{
			DispensingUnitValues = (HashMap)DispensingUnitlist.get(i);
			code = (String)DispensingUnitValues.get("code");
			desc = (String)DispensingUnitValues.get("desc");
			out.println("DispensingUnit(\"" +code+ "\",\"" +desc+ "\"); ");
		}
	}
if(func_mode!= null && func_mode.equals("searchManufacturer"))
		{
		String tradeId				= (String) hash.get( "code" );
		out.println("setManufacturerName('"+bean.getManufacturerName(tradeId)+"');");
	   }
if(func_mode!= null && func_mode.equals("trade_tab"))
	{
		//String trade_code				= (String) hash.get("code");
		String trade_id				= (String) hash.get("trade_id");
		String trade_name				= (String) hash.get("trade_name");
		String manufacturer_id				= (String) hash.get("manufacturer_id");
		String manufacturer_name				= (String) hash.get("manufacturer_name");
		Drug_code_value				= (String) hash.get("Drug_code_value");
		mode				= (String) hash.get("mode");
		ArrayList TradeList=new ArrayList(); 
		ArrayList TradeListQuery=new ArrayList(); 
        HashMap Tradevalues=new HashMap();
        HashMap trade_record=new HashMap();
		TradeList=bean.getTradeNamesAll();
		TradeListQuery=bean.getTradeResult();
		if(TradeList.size()!=0)
        {
			TradeList=bean.getTradeNamesAll();
		    for(int k=0; k<TradeList.size(); k++)
			{
				Tradevalues			=	(HashMap) TradeList.get(k);
				bean_trade_id	=	(String)Tradevalues.get("trade_id");
			if(bean_trade_id.equals(trade_id))
				{
					dup_found	=	true;
					out.println("DuplicateNotAllowed();");
					break;
			    }
		    }
    	}
if(!mode.equals("1"))
  { 
    if(TradeListQuery.size()!=0)
      {
			
		 TradeListQuery=bean.getTradeResult();
		 for(int k=0; k<TradeListQuery.size(); k++)	
			 {
				Tradevalues			=	(HashMap) TradeListQuery.get(k);
				bean_trade_id	=	(String)Tradevalues.get("trade_id");
				if(bean_trade_id.equals(trade_id))
					{
					dup_found	=	true;
					out.println("DuplicateNotAllowed();");
					break;
			        }
		     }
       }
     else if(TradeList.size()==0)
	 {
		/***Check Duplicate Record***/
		for(int k=0; k<TradeList.size(); k++)
			{
				Tradevalues			=	(HashMap) TradeList.get(k);
				bean_trade_id	=	(String)Tradevalues.get("trade_id");
				if(bean_trade_id.equals(trade_id))
					{
						dup_found	=	true;
						out.println("DuplicateNotAllowed();");
						break;
	    	        }
	       }
        }
    }
	if(!dup_found)
		{
			trade_record	=	new HashMap();
			trade_record.put("trade_id",trade_id);
			trade_record.put("trade_name",trade_name);
			trade_record.put("manufacturer_id",manufacturer_id);
			trade_record.put("manufacturer_name",manufacturer_name);
			trade_record.put("select",vaY);
			trade_record.put("mode",mode);
			bean.setTradeNamesAll(trade_record);
			out.println("Duplicate('"+Drug_code_value+"');");
		}
	}

if(func_mode!= null && func_mode.equals("Trade_check"))
	{
	vaY		        = (String) hash.get( "vaY" );
	mode		        = (String) hash.get( "mode" );
	String trade_id_check		        = (String) hash.get( "trade_id" );
	ArrayList TradeList=new ArrayList(); 
	ArrayList TradeListQuery=new ArrayList(); 
	TradeList=bean.getTradeNamesAll();
	TradeListQuery=bean.getTradeResult();
    HashMap Tradevalues=new HashMap();
	if(mode.equals("2"))
	 {
		/***Check Duplicate Record***/
		for(int k=0; k<TradeListQuery.size(); k++)
			{
			  Tradevalues			=	(HashMap) TradeListQuery.get(k);
			  bean_trade_id	=	(String)Tradevalues.get("trade_id");
			  if(bean_trade_id.equals(trade_id_check))
				 {
				   Tradevalues.put("select",vaY);
					 break;
				  }
			}
      }
	  else if(mode.equals("1"))
	  {
		for(int k=0; k<TradeList.size(); k++)
			{
			  Tradevalues			=	(HashMap) TradeList.get(k);
			  bean_trade_id	=	(String)Tradevalues.get("trade_id");
			  if(bean_trade_id.equals(trade_id_check))
				  {
					Tradevalues.put("select",vaY);
					break;
				  }
		   }
       }
   }
if(func_mode!= null && func_mode.equals("packSize"))
    {
	  eqvl_value=bean.getEqvlValue(pres_base_uom_value,stock_uom);
	  if(eqvl_value.equals(""))
	   {
        eqvl_value="";
	   }
	   bean.setEqvlvalue(eqvl_value);
	   out.println("assignPackSize('"+eqvl_value+"');");
   }
if(func_mode!= null && func_mode.equals("toolBar"))  
	{
	   //out.println("alert(\"toolBarString:"+request+"\")" ) ;
       String toolBarString = request.getQueryString() ;
	   session.removeValue("queryString") ;
       session.putValue( "queryString", toolBarString ) ;
	   //out.println("alert(\"After:"+session.getValue("queryString")+"\")") ;
    }
if(func_mode!= null && func_mode.equals("drug_code_check"))
  {
	int value=bean.getDrug_Code(Drug_code);
    if(value!=0)
	{
     out.println("DrugCodeCheck();");
	}
  }

            _bw.write(_wl_block2Bytes, _wl_block2);

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
