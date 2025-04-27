package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Date;
import eST.RequestBean;
import eST.RequestDetailBean;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.*;
import eST.ParameterForEntityBean;
import java.sql.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __requestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/RequestValidate.jsp", 1720356763187L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
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

/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/04/2017		IN061750			Badmavathi B										ML-MMOH-CRF-0567		
08/05/2018		IN067386			Shazana 										  	ML-MMOH-SCF-0979 - Conversion factor live issue 
10/08/2018		IN067844			Shazana												ML-MMOH-CRF-1200
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172
3/11/2021		TFS:25345			Shazana												MO-CRF-20172-US004
-------------------------------------------------------------------------------------------------------------------------------
*/   

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			=		(String)session.getAttribute("LOCALE");
    String check_status		=		request.getParameter("check_status");
    String stitem_code		=		request.getParameter("item_code");
	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");
    int functionType		=		Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;

  
	RequestBean bean		=		(RequestBean) getBeanObject(bean_id, bean_name, request  );
	ParameterForEntityBean bean2 =  (ParameterForEntityBean) getBeanObject("parameterForEntityBean","eST.ParameterForEntityBean" ,request ); // added for ML-MMOH-CRF-1200
	bean.setLanguageId(locale); 

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");
	System.out.println("hash"+hash);
	boolean result			=		false;
	boolean result1			=		false;
	String message			=		"";
	String flag				=		"";

	switch (functionType) {

	case 1:
		{
			String doc_type_code = (String) hash.get("doc_type_code");
			if (doc_type_code != null && doc_type_code.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			out.println("validateDocNo("+bean.isDocNoAutoGenYN(doc_type_code)+");");
		}
		break;
	case 2: // case - 2 will be executed on focus lost of Store Code
		{
				java.util.HashMap addResult = bean.addDetailRecord(hash);
				//out.println("assignResult("+addResult.get("result")+",getMessage(\""+addResult.get("message")+"\",'ST'), \"0\");");
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}
		break;
	case 3:
		{
			String request_by_store = (String) hash.get("request_by_store");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			java.util.HashMap resultMap = bean.canAuthorize(request_by_store);
			if (resultMap != null) {
				String authorize = (String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
//				out.println("alert ('"+authorize+"');");
				out.println("setAuthorize('"+authorize+"');");
/*				String parent_store = (String)resultMap.get("PARENT_STORE_CODE");
				parent_store = bean.checkForNull(parent_store,"");
				out.println("alert ('"+parent_store+"');");
				out.println("setParentStoreCode('"+parent_store+"');");
				if (parent_store != null && parent_store.trim() != "") {
					out.println("clearListItems('formRequestHeader.item_class_code'); ");
					ArrayList itemClasses = bean.getItemClasses(request_by_store,parent_store);
					for(int i=0; i< itemClasses.size(); i++) {
						String[] record = (String[])itemClasses.get(i);
						out.println("addListItem(\"formRequestHeader.item_class_code\", \"" + record[0] + "\",\"" + record[1] + "\");");
					}
				}			  */
			}
		}
		break;
	case 4: {
				String request_by_store = (String) hash.get("request_by_store");
				String request_on_store = (String) hash.get("request_on_store");
				if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				out.println("clearListItems('formRequestHeader.item_class_code'); ");
				out.println("clearListItems('formRequestQueryCriteria.request_on_store'); ");
				ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
				HashMap record = null;
				for(int i=0; i< itemClasses.size(); i++) {
					record = (HashMap)itemClasses.get(i);
					out.println("addListItem(\"formRequestHeader.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
				}
		}
		break;
	/* PE Commented
	case 5:
		{
				java.util.HashMap addResult = bean.addDetailRecordModifyMode(hash);				
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}
		break; */
	case 6:
		{
			String stock_item_yn = "Y";
			try {
				try {
					String item_code	= request.getParameter("item_code");
					String store_code	= request.getParameter("store_code");	
					bean.setRequest_by_store(store_code);
					String store_code_to	= request.getParameter("store_code_to");
					String phy_inv_id   = "";
					HashMap hmStockAvailabilityStatus = null;//added for ML-MMOH-SCF-0396 
					
					 String facility_id		=		(String) session.getValue( "facility_id" ) ;//MO-CRF-20172
					 String lastIssueDate = "";  //end   
					String[] stParameters = {item_code, store_code, "0", "N", "", "N", store_code_to }; //ML-MMOH-SCF-0396 
					ArrayList alBatchList=new ArrayList();
					result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code_to,store_code);
					if(result1){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code_to}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formRequestDetail.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					}
					//Added for ML-BRU-SCF-1686 by B.Badmavathi on 26/07/2016 starts
					HashMap record =  null;
					ArrayList itemClasses =new ArrayList();
					String chkParameters[] = {store_code,store_code_to,bean.getLanguageId()};
					itemClasses = bean.fetchRecords(bean.getStRepositoryValue("SQL_MM_ITEM_CLASS_CODE_FOR_STORE_SELECT_LIST"),chkParameters);
					String item_class_code = "";
					item_class_code = (String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ITEM_CLASS_CODE_MM_ITEM"),new String[]{item_code}).get("ITEM_CLASS_CODE");
					boolean flag1 = false;
					for(int i =0; i<itemClasses.size(); i++) {
						record = (HashMap)itemClasses.get(i);
						if(record.containsValue(item_class_code))
									flag1 = true;
						if(flag1)
							break;
					}
					if(!flag1)
						throw new Exception("ITEM_STORE_ITEM_CLASS_NOT_FOUND");
					//Added for ML-BRU-SCF-1686 by B.Badmavathi on 26/07/2016 ends
					//write logic to check no_of_days for MO-CRF-20172
						lastIssueDate = bean.getLastIssuedDate(store_code,facility_id,item_code);	
						if(lastIssueDate!=null){
							java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd-MM-yyyy" ) ; 
							java.util.Date currentdate=new java.util.Date();
							String sysdt=dateFormat.format(currentdate); 
							
							Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(lastIssueDate);
							String strDate =  new SimpleDateFormat("yyyy-MM-dd").format(date1);
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							String strLastIssuedDate= formatter.format(date1);
							 
							 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
							Date fdate=format.parse(sysdt); 
			   			 	Date tdate=format.parse(strLastIssuedDate);
			   			 	long diffInDays =  fdate.getTime() - tdate.getTime(); 
							long differenceInDays =  (diffInDays / (24 * 60 * 60 * 1000));
			      			System.out.println("differenceInDays---->" + differenceInDays);
			      			System.out.println("store_code---->" + store_code);
			      			System.out.println("item_code---->" + item_code);
			   			 	int noOfDays = bean.getNoOfDaysItemStore(store_code, item_code);
			   			 	String strNoofDays = String.valueOf(noOfDays);
			   			 	if (!strNoofDays.equals("0") &&  differenceInDays<noOfDays){//modified for 26243
			   			 		System.out.println("throw exception");
			   			 		throw new Exception("ITEM_STORE_NO_OF_DAYS_GREATER"); 
			   			 	}
			   			 	
						} 
					//MO-CRF-20172 END  
					alBatchList=bean.getBatchDetails(item_code,store_code);            
					
					stock_item_yn = bean.checkForNull((String)(alBatchList.get(0)),"N");
					
					out.println("document.forms[0].stock_item_yn.checked="+stock_item_yn.equals("Y"));
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
					/*PE Code*/
					alBatchList=bean.getBatchDetails(item_code,store_code_to); 
					stock_item_yn = bean.checkForNull((String)(alBatchList.get(0)),"N");
					String available_stock=	bean.checkForNull((String)alBatchList.get(1),"0");
					if(bean.checkForNull(stock_item_yn).equals("N")) {
						throw new Exception("NOT_STOCK_ITEM");
					}
					//added ML-MMOH-SCF-0396
					//-start
					try{
						hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
					}catch (Exception exception) {
						throw new Exception("ITEM_STORE_NOT_FOUND");
					}//added ML-MMOH-SCF-0396 -end
					out.println("document.formRequestDetail.available_stock.value=\""+available_stock+"\";");
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
					/*PE*/
				}
				catch (Exception exception) {
					exception.printStackTrace();

					if (exception.getMessage().equals("RECORD_ALREADY_EXISTS"))
						throw exception;
					if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED"))
						throw exception;
					/*PE Code*/
					if(stock_item_yn.equals("N")) {
						throw new Exception("NOT_STOCK_ITEM");
					}
					/*MO-CRF-20172*/
					if (exception.getMessage().equals("ITEM_STORE_NO_OF_DAYS_GREATER"))
						throw exception;
					/*PE*/
					//added ML-MMOH-SCF-0396 starts
					if (exception.getMessage().equals("ITEM_STORE_NOT_FOUND"))
						throw exception;
					else if(exception.getMessage().equals("ITEM_STORE_ITEM_CLASS_NOT_FOUND"))//Added for ML-BRU-SCF-1686 by B.Badmavathi on 26/07/2016
						throw exception;//Added for ML-BRU-SCF-1686 by B.Badmavathi on 26/07/2016
					else
					////added ML-MMOH-SCF-0396 ends
					throw new Exception("REQ_ON_ITEM_STORE_NOT_FOUND");
				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
		break;
	/* PE COMMENTED case 7:
		{
			String stock_item_yn = "";
			try {
				try {
					String item_code	= request.getParameter("item_code");
					String store_code	= request.getParameter("store_code");					
					ArrayList alBatchList=new ArrayList();
					alBatchList=bean.getBatchDetails(item_code,store_code);      
					stock_item_yn =(String)(alBatchList.get(0));
					result = true;
					String available_stock=	(String)alBatchList.get(1);
					if(stock_item_yn.equals("N")) {
						result = false;
						message = "NOT_STOCK_ITEM";
					}																  
					out.println("document.formRequestDetail.available_stock.value=\""+available_stock+"\";");
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
					exception.printStackTrace();
					if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
						throw exception;
					}
					message = "REQ_ON_ITEM_STORE_NOT_FOUND";
					if(stock_item_yn.equals("N")) {
						result = false;
						message = "NOT_STOCK_ITEM";
					}									
					throw new Exception(message);
				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
		break;*/
	case 8:
		{
		 try{
			try{
					String item_code = request.getParameter("item_code");
					String request_type = request.getParameter("request_type");
					String uom_code		= request.getParameter("uom_code");
					String store_code   = request.getParameter("store_code");
					//String req_uom_code   = request.getParameter("req_uom_code");
					ArrayList array = new ArrayList(); 
					array = (ArrayList)bean.getRequestTypeValue(item_code,request_type);
					
				
					//String item = (String)array.get(0);
					result = true;
					String default_uom = bean.getDefaultUOM(item_code,store_code);
					
					out.println("clearListItemsNoSelect('document.formRequestDetail.pur_uom_code'); ");

			 		ArrayList alEncounterList = bean.getPur_uom_code_List(uom_code,item_code);
					HashMap record = null;
					for(int i=0; i< alEncounterList.size(); i++) 
					{
					record	=	(HashMap)alEncounterList.get(i);
					String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2	=	(String)record.get("SHORT_DESC");
					//if(uom_code !=null || uom_code ==""){
					//	out.println("addListItem(\"document.formRequestDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +default_uom+"\") ; ");
					//}else{
						out.println("addListItem(\"document.formRequestDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+"\") ; ");
						out.println("selectUOMcode('"+default_uom+"');");
					//}
					
					}
			}catch(Exception exception){
					throw new Exception("INVALID_ITEM_FOR_REQ_TYPE");
			}
		 }catch(Exception exception){
			 result		=	false;
			 message		=	exception.getMessage();
			 exception.printStackTrace();
		 }
		 finally{
			 out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		 }
				
			
		}
		break;
	case 9:
		{
		  try{
				String store_code = request.getParameter("store_code");
				String authorize_res = bean.getAuthorizeForRequest(store_code);
				message = authorize_res;
				result = true;

		  }catch(Exception exception){
			 result		=	false;
			 message		=	exception.getMessage();
			 exception.printStackTrace();
		  }
		  finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
	case 10:
			{
			
			try { 
				String uom_code		= request.getParameter("uom");
				String pur_uom_code = bean.checkForNull(request.getParameter("pur_uom_code"));
				String item_code = request.getParameter("item_code");

				//Added against Inc#32347 by Sakti Sankar
				String uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{uom_code, locale}).get("SHORT_DESC");
				
				String pur_uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{pur_uom_code, locale}).get("SHORT_DESC");
				//Added ends

				//Added by Sakti sankar against RUT-SCF-0248 displaying special characters
				
				pur_uom_desc  = bean.checkForNull(pur_uom_desc,"");
				uom_desc      = bean.checkForNull(uom_desc,"");

				uom_desc = uom_desc.replaceAll(" ","%20");
				uom_desc = java.net.URLEncoder.encode(uom_desc,"UTF-8");
				uom_desc = uom_desc.replaceAll("%2520","%20");

				pur_uom_desc = pur_uom_desc.replaceAll(" ","%20");
				pur_uom_desc = java.net.URLEncoder.encode(pur_uom_desc,"UTF-8");
				pur_uom_desc = pur_uom_desc.replaceAll("%2520","%20");
				//Added ends

			// Changed By Rams for the CRF 537.3 3/24/2010
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, pur_uom_code,item_code}).get("COUNT"));
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_desc+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_desc;
				String stEqvl_value=""+Double.parseDouble((String)stEqvl_value1.get("CONV_FACTOR"));
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;

				}else if(am_count!=0){
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");
				
				String conver=stEqvl_value+" "+uom_desc+" = 1 "+pur_uom_desc;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				
				result=true;
				}else{
				String stEqvl_value="1";
				String conver=stEqvl_value+" "+uom_desc+" = 1 "+pur_uom_desc;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
		
				}
				
				//added for ml-mmoh-SCF-0979
				String store_code= request.getParameter("store_code");								
				double uom_convFactor= bean.getConvFactTemp(item_code, store_code);
				/*int uom_int = (int) uom_convFactor;				 
				String uom_convFactor1 = String.valueOf(uom_int);  				 
				//out.println("setUOMConvFactor2('"+uom_convFactor1+"');");*/
				out.println("setUOMConvFactor2('"+uom_convFactor+"');");
				//added for ml-mmoh-SCF-0979
				
			}
			catch (Exception exception) {
				exception.printStackTrace();
				
				throw new Exception("NO_CONV_FAC_FOR_REQ_UOM_CODE");
			}
				finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		
			}
		break;

     /*  This will be executed when clicking the check boxes  added by Pankaj on 06/08/2004 */

 	case 11: 
		{
                ArrayList alItemKeys = new ArrayList();
				String usage_type		=		bean.checkForNull(request.getParameter("usage_type"));//18/09/12
				

				for(int i=0;i<bean.getItemKeys().size();i++) {
			      alItemKeys.add(bean.getItemKeys().get(i));	
		         } 
				
				java.util.ArrayList newKeys = bean.getItemKeysAdded();

				if (newKeys != null && newKeys.size() >0) {
					alItemKeys.addAll(newKeys);
				}

				HashMap hmItemStore = (HashMap)bean.getHmItemDetail();
				String itemStoreKey = "";

				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize = alItemKeys.size();
					RequestDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (RequestDetailBean)hmItemStore.get(itemStoreKey);
						if(itemStoreKey.equals(stitem_code)){
							
							detailBean.setCheck_box_status(check_status);
							detailBean.setUsagetype(usage_type);//18/09/12
                            hmItemStore.remove(itemStoreKey);
                            hmItemStore.put(itemStoreKey,detailBean);
                            bean.setHmItemDetail(hmItemStore);
						
							break ;
                            //hmItemDetail.put(item_code, new RequestDetailBean(detailRecord));
						}

					}//end of For loop
				}//end of if condition
              
			//out.println("assignResult("+addResult.get("result")+",getMessage(\""+addResult.get("message")+"\"), \"0\");");
		}
		break;


	 case 12: 
		{	
			try{
				ArrayList doc_no=bean.getPrintDocNo();
				String pdocno = "";
				for(int i=0;i<doc_no.size();i++){
					pdocno=(String)doc_no.get(i);
					//bean.doOnlineReportPrinting(pdocno);	
					bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
				}
				result =  true ;
			    message = request.getParameter("msg");

			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
			finally{
					out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;

 case 13: 
		{	
			try
			{
				String item_code = request.getParameter("item_code");
				String store_code = request.getParameter("store_code");
				int no_of_decimals = Integer.parseInt((String)request.getParameter("no_of_decimals"));
				String dec_allowed_yn = request.getParameter("dec_allowed_yn");
				String[]  minmaxarg = {""+bean.getConvFactTemp(item_code,store_code),item_code, store_code};
				HashMap hmminmax = new HashMap();
				hmminmax =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);
/**
* @Name - Mahesh
* @Date - 12/01/2010
* @Inc# - IN015496
* @Desc - Code added to accept decimal values dynamically.
*/
	
				//if((bean.getAllowDecimalsYN(item_code)).equals("Y")){
				if((dec_allowed_yn).equals("Y")){
					//out.println(" document.getElementById("Qty_onhand_label").innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),bean.getNoOfDecimals())+"</B>' ");
					out.println(" document.getElementById('Qty_onhand_label').innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),no_of_decimals)+"</B>' ");
				}else{
					out.println(" document.getElementById('Qty_onhand_label').innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),0)+"</B>' ");
				}
				out.println(" document.getElementById('max_stk_qty_label').innerHTML = '<B>"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"</B>'");
				out.println("document.getElementById('qty_on_hand').value = '"+bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0")+"';");
				out.println("document.getElementById('max_stk_qty').value = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"';");

				result =  true ;
			
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
			finally{
					out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
	

		}
		break;
		case 14:
			{
		result = false;
			try { 
				String item_code       =   (String)request.getParameter("item_code");
				String frm_store_code	=	(String)request.getParameter("frm_store_code");
				String to_store_code	=	(String)request.getParameter("to_store_code");
				double frm_tmp_conv=bean.getConvFactTemp(item_code,frm_store_code);
				double to_tmp_conv=bean.getConvFactTemp(item_code,to_store_code);
				out.println("setTempConvFactor('"+frm_tmp_conv+"','"+to_tmp_conv+"');");
		
				result=true;
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		break;
		case 15:
		{
			String request_by_store = (String) hash.get("request_by_store");
			
				bean.setRequest_by_store(request_by_store);
				//To populate the requisition_on_stores
					out.println("clearListItems('formRequestQueryCriteria.request_on_store'); ");
					ArrayList req_by_stores = bean.getOnStores(bean.getRequest_by_store());
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formRequestQueryCriteria.request_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}
				
		
			}
		break;
		case 16: {
				String request_by_store = (String) hash.get("request_by_store");
				String request_on_store = (String) hash.get("request_on_store");
				if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				
				out.println("clearListItems('formRequestQueryCriteria.item_class_code'); ");
				ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
				HashMap record = null;
				for(int i=0; i< itemClasses.size(); i++) {
					record = (HashMap)itemClasses.get(i);
					out.println("addListItem(\"formRequestQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
				}
		}
		case 17: {
			try{
				String kit_template_code = (String)request.getParameter("kit_template_code")==null?"":(String)request.getParameter("kit_template_code");
				String store_code	= request.getParameter("store_code");					
				String store_code_to	= request.getParameter("store_code_to");					
				if(!(kit_template_code.equals("")))
				bean.kitTemplateValues(kit_template_code,store_code,store_code_to);
				ArrayList alDetailData=bean.getKitDtlData();
								
				int count = (int)bean.getCount();
					HashMap ht = new HashMap();
				if(alDetailData.size()>count){
					ht = (HashMap)alDetailData.get(count);
				
						out.println("document.formRequestDetail.item_code.value = '"+bean.checkForNull((String)ht.get("ITEM_CODE"),"")+"';");
						out.println("document.formRequestDetail.item_desc.value = \""+bean.checkForNull((String)ht.get("SHORT_DESC"))+"\";");
						 
						out.println("document.formRequestDetail.uom.value = '"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"';");
						out.println("document.formRequestDetail.req_uom_qty.value ='"+bean.checkForNull((String)ht.get("QUANTITY"),"")+"';");
						out.println("document.formRequestDetail.required_qty.value ='"+bean.checkForNull((String)ht.get("QUANTITY"),"")+"';");
						out.println("document.formRequestDetail.temp_uom.value = '"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"';");
						out.println("document.formRequestDetail.kit_template_uom.value = '"+bean.checkForNull((String)ht.get("KIT_UOM_DESC"))+"';");
						out.println("document.formRequestDetail.kit_item_yn.value = '"+bean.checkForNull((String)ht.get("KIT_ITEM_YN"),"N")+"';");
						out.println("document.formRequestDetail.kit_uom_code.value = '"+bean.checkForNull((String)ht.get("KIT_UOM_CODE"))+"';");
						out.println("document.formRequestDetail.def_issue_uom.value = '"+bean.checkForNull((String)ht.get("DEF_ISSUE_UOM"))+"';");
						out.println("document.getElementById('uom_label').innerHTML = '<B>"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"</B>';");
						out.println("document.formRequestDetail.kit_temp_code.value = '"+bean.checkForNull((String)ht.get("KIT_TEMPLATE_CODE"),"")+"';");
						out.println("document.formRequestDetail.usage_type.value = '"+bean.checkForNull((String)ht.get("USAGE_TYPE"),"")+"';");
						out.println("kitGetStatus();");
					result = true;
				}else{
					out.println("statusOfItem();");
					out.println("statusOfList();"); //Added by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
					result = false;
				}
			}catch(Exception e){
				result = false;
				message = e.getMessage();
				e.printStackTrace();
			}
		}
		break;
	case 18: // case - 2 will be executed on focus lost of Store Code
		{
				java.util.HashMap addResult = bean.addDetailRecord1(hash);
				//out.println("assignResult("+addResult.get("result")+",getMessage(\""+addResult.get("message")+"\",'ST'), \"0\");");
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}
		break;
	case 19:{
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			HashMap ht = new HashMap();
			alDtlData = bean.getKitDtlData();
			String store_code	= request.getParameter("store_code");					
			String to_store_code	= request.getParameter("to_store_code");					
			HashMap hmStockAvailabilityStatus =  null;
			for(int i=0;i<alDtlData.size();i++){
				ht = (HashMap)alDtlData.get(i);
				String[] stParameters = {(String)ht.get("ITEM_CODE"), store_code, "0", "N", "", "N", to_store_code };
					result = bean.isPhysicalInventoryProcessStartedForStore((String)ht.get("ITEM_CODE"),store_code,to_store_code);
					if(result){
						errorList.add("PHY_INV_PROCESS_INITIATED");
						errorList.add((String)ht.get("SHORT_DESC"));
					}
					try{
						hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y")){
							if( hmStockAvailabilityStatus.get("available_stock").equals("0")){
								//errorList.add("STOCK_NOT_AVAILABLE");
								//errorList.add((String)ht.get("SHORT_DESC"));
							}
						}else{
							errorList.add("NOT_STOCK_ITEM");
							errorList.add((String)ht.get("SHORT_DESC"));
						}
					}catch(Exception e){
						if(!result){
							errorList.add("REQ_ON_ITEM_STORE_NOT_FOUND");
							errorList.add((String)ht.get("SHORT_DESC"));
							
							//Added by Rabbani #Inc no:39550(AAKH-SCF-0050) on 06-JUN-2013
							 RequestDetailBean detailrequestBean;
							 detailrequestBean					=		bean.getItemDetail((String)ht.get("ITEM_CODE"));
                             detailrequestBean.setCheck_box_status("");
						}
					}
			}
			out.println("displayMessage('"+errorList+"');");
			result		=	true;
	}
	break;
	case 20:{
		String item_code =  request.getParameter("item_code");
		RequestDetailBean requestDetail;
		requestDetail					=			bean.getItemDetail(item_code);
	//	String req_uom_qty				=			requestDetail.getReqUomQty();
		String required_qty				=			requestDetail.getRequired_qty();
		if(required_qty.equals("0"))
			result = false;
		else
			result = true;
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	break;
	case 21:{
		String strSortBy =  request.getParameter("order");
		bean.setTogglePoint(strSortBy);
		out.println(" assignResult(" + true + ",\"" + "" +"\", \"0\");") ;
	}
	
	break;
	
	case 22:
		{
	  String pur_uom_am_chk = request.getParameter("pur_uom_code");
	 ArrayList alParameters	=			new ArrayList();
     alParameters.add(pur_uom_am_chk);
     alParameters.add(locale);
     HashMap hmRecord =	(HashMap)bean.fetchRecord("select pur_uom_yn,sale_uom_yn from am_uom_lang_vw where uom_code=? and language_id=?",alParameters);
	 String pur_uom_yn = bean.checkForNull((String)hmRecord.get("PUR_UOM_YN"));
	 String sale_uom_yn = bean.checkForNull((String)hmRecord.get("SALE_UOM_YN"));

	 if(sale_uom_yn.equalsIgnoreCase("Y") && pur_uom_yn.equalsIgnoreCase("Y"))
			
        result = true;
						
	 else
		 result = false;
     out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;

	 }
	break;
	case 23:
		{
	  String request_by_store = request.getParameter("request_by_store");
		ArrayList alItemKeys = new ArrayList();

				for(int i=0;i<bean.getItemKeys().size();i++) {
			      alItemKeys.add(bean.getItemKeys().get(i));	
		         } 
				
				java.util.ArrayList newKeys = bean.getItemKeysAdded();

				if (newKeys != null && newKeys.size() >0) {
					alItemKeys.addAll(newKeys);
				}

				HashMap hmItemStore = (HashMap)bean.getHmItemDetail();
				String itemStoreKey = "";
				result=false;
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize = alItemKeys.size();
					RequestDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (RequestDetailBean)hmItemStore.get(itemStoreKey);
					  String count="0";
					  String doc_no=bean.checkForNull(bean.getDoc_no(),"0");
					if(detailBean.getCheck_box_status().equals("Y")){
					count=(String)bean.fetchRecord("select count(hdr.DOC_NO) count from st_request_hdr hdr,st_request_dtl dtl where hdr.REQ_BY_STORE_CODE=? and hdr.DOC_NO=dtl.DOC_NO and dtl.ITEM_CODE=? and hdr.DOC_TYPE_CODE=dtl.DOC_TYPE_CODE and  hdr.REQUEST_STATUS='W' and hdr.FACILITY_ID=dtl.FACILITY_ID and dtl.DOC_NO not in(?) ",new String[]{request_by_store,itemStoreKey,doc_no}).get("COUNT");
					}
					if(!count.equals("0")){
					result=true;
					break;
					}
                 	}
				}
			
              
	   out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;

	 }
	break;
	case 24:{
			String item_code       =   (String)request.getParameter("item_code");
			String to_store_code	=	(String)request.getParameter("to_store_code");
			String fm_store_code	=	(String)request.getParameter("fm_store_code");
			String issue_uom_code	=	(String)request.getParameter("issue_uom_code");
			bean.clearConvMap();//added for ML-MMOH-CRF-1200
			HashMap conv_factors	=	(HashMap)bean.getConvFactTemp(item_code,fm_store_code,to_store_code,issue_uom_code);
			out.println("setMultiples('"+(String)conv_factors.get("FROM_STORE_MULTIPLES")+"','"+(String)conv_factors.get("TO_STORE_MULTIPLES")+"','"+(String)conv_factors.get("BATCH_QTY_MULTIPLES")+"','"+(String)conv_factors.get("ISSUE_UOM_MULTIPLES")+"');");
			result = true;
	}
	break;
	case 25:
		{
		            String item = "";
					String item_code = request.getParameter("item_code");
					String request_type = request.getParameter("request_type");
					//System.out.println("request_type:671"+request_type);
		            ArrayList req_type = new ArrayList(); 
					req_type = (ArrayList)bean.getRequestTypeValue(item_code,request_type);
                   //System.out.println("req_type:673"+req_type);
					item = bean.checkForNull((String)req_type.get(0));
                   //System.out.println("item:674"+item);
					result = true;
					if(request_type.equals("S")){
					if(item.equals("")) {
					//System.out.println("item:667"+item);
					 result = false;
					}
                  }					
                  out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;

	 }
	 break;
	 //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
	 case 26: 
	 { 
			bean.setHdrRemarks_Desc((String)hash.get("hdr_remarks_desc"));
			bean.setHdrRemarks_Code((String)hash.get("hdr_remarks_code"));
	 }
		break;
		//Added for ML-MMOH-CRF-0567 starts
	 case 27: 
	 { 
		 String store_code = request.getParameter("store_code");
		 String item_code = request.getParameter("item_code");
		 //String store_type =(String)bean.fetchRecord("select STORE_TYPE_FLAG from ST_STORE where store_code=?",new String[]{store_code}).get("STORE_TYPE_FLAG");//COMMENTED FOR ML-MMOH-1200
		 /*ADDED FOR ML-MMOH-CRF-1200 START*/
		  	String thirdPartyMS = "EPHISSTD1-PHS-MAIN_STORE";
			String thirdPartyStore ="N";
			
			HashMap hmRecord =	(HashMap)bean.fetchRecord("SELECT STANDARD_CODE, SEGMENT_ID, ELEMENT_ID FROM XH_STANDARD_CONTROL_SEG WHERE DEFAULT_VALUE=?",store_code);		 
			 String standardCode = bean.checkForNull((String)hmRecord.get("STANDARD_CODE"));
			 String segmentId = bean.checkForNull((String)hmRecord.get("SEGMENT_ID"));	
			 String elementId = bean.checkForNull((String)hmRecord.get("ELEMENT_ID"));	
			 String thirdPartyFormat= standardCode+"-"+segmentId+"-"+elementId;		
			 if(thirdPartyFormat.equalsIgnoreCase(thirdPartyMS)){
				  thirdPartyStore ="Y";
			 }
		 
		 if( thirdPartyStore.equalsIgnoreCase("Y") && bean.isSite_spec_yn() ){ /*ADDED FOR ML-MMOH-CRF-1200 END*/
			 String default_uom = bean.getBaseUOM(item_code);
			 out.println("selectUOMcode('"+default_uom+"');");
			 result= true;
		 }
		 else
			 result = false;
		 out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
	 }
		break;
		//Added for ML-MMOH-CRF-0567 ends	
		//added for MO-CRF-20172 starts
	 case 28:
	 {
		 String item_code =  request.getParameter("item_code");
		 String request_by_store =  request.getParameter("request_by_store");  
		 String facility_id		=		(String) session.getValue( "facility_id" ) ;
		 System.out.println("item_code: "+item_code);  
		 System.out.println("request_by_store: "+request_by_store); 
		 System.out.println("facility_id: "+facility_id);  
		RequestDetailBean requestDetail;
		/* requestDetail	=	bean.getItemDetail(item_code);
		 System.out.println("requestDetail: "+requestDetail);*/
		//int noOfDays = bean.getNoOfDaysItemStore(request_by_store, item_code); 
		 try{
			 String lastIssueDate = bean.getLastIssuedDate(request_by_store,facility_id,item_code);   
				if(lastIssueDate!=null){
					java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd-MM-yyyy" ) ; 
					java.util.Date currentdate=new java.util.Date();
					String sysdt=dateFormat.format(currentdate); 
					
					Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(lastIssueDate);
					String strDate =  new SimpleDateFormat("yyyy-MM-dd").format(date1);
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					String strLastIssuedDate= formatter.format(date1);
					 
					 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					Date fdate=format.parse(sysdt); 
					 	Date tdate=format.parse(strLastIssuedDate);
					 	long diffInDays =  fdate.getTime() - tdate.getTime(); 
					long differenceInDays =  (diffInDays / (24 * 60 * 60 * 1000));
		  			System.out.println("differenceInDays---->" + differenceInDays);
					 	int noOfDays = bean.getNoOfDaysItemStore(request_by_store, item_code);
					 	String strNoofDays = String.valueOf(noOfDays);
					 	if ( !strNoofDays.equals("0") &&  differenceInDays<=noOfDays)
					 		result = true; 	 	
				} 
		 }
		catch (Exception exception) {
			exception.printStackTrace();  
		}
		 finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
	 }
		 
	default :
		//To be replaced with proper message
		
		return;
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
