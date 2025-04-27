package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.Common.*;
import eST.*;
import java.sql.*;
import java.text.NumberFormat;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __changeexpiryflagvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ChangeExpiryFlagValidate.jsp", 1719809944695L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
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

/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
03/09/2020      IN073899            Haribabu                                MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");

	ChangeExpiryFlagBean bean		=		(ChangeExpiryFlagBean)getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request ) ;  
	bean.setLanguageId(locale);

	String item_code				=		request.getParameter("item_code");
	String validate					=		request.getParameter("validate");
	String qty						=		"";
	String message					=		"";
	String flag						=		"INVALID_VALIDATE_FLAG";
	boolean	result					=		false;
	int no_of_decimals              =       0;
	try {
		if (validate.equals("QOH")) {

			flag					=		"";
			try{
				String expiry_yn = bean.checkForNull((String)request.getParameter("expiry_yn"),"N");
				bean.setItem_code(item_code);
				bean.setExpiry_yn(expiry_yn);
				bean.loadData();

				ArrayList alParameters	=		new ArrayList(1);
				alParameters.add(item_code);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId());

				HashMap hmRecord		=		new HashMap();
				try {
					hmRecord			=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_QOH"),alParameters);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				qty						=		(String)hmRecord.get("QTY" )	;
				
				/**
				* @Name - Suri
				* @Date - 19/01/2010
				* @Inc# - IN015496
				* @Desc - Code added to accept decimal values dynamically.
				* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			   */

				if((bean.getAllowDecimalsYN(item_code)).equals("Y"))
					no_of_decimals=bean.getNoOfDecimals();
				else
					no_of_decimals=0;
				out.println("setQty(\""+bean.setNumber((bean.checkForNull(qty,"0")),no_of_decimals)+"\");");

				hmRecord				=		new HashMap();
				try {
					   hmRecord			=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_PH_ASSOCIATION_CHECK"));
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
              
               /* Commented by Rabbani #Inc no :50968 on 11-09-2014 Starts
			   String PHinstalled		=		"";
                PHinstalled				=		(String)hmRecord.get("INSTALL_YN");
				PHinstalled				=		PHinstalled.trim();
        
                hmRecord				=		new HashMap();
				String stPHAssocaited	=		"N" ;

                if( PHinstalled.equals("Y") )
				{ 
						try {
							 hmRecord	=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_ASSOCIATED_WITH_PH_COUNT"),item_code);
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
						String count	=		"";
						count			=		(String)hmRecord.get("COUNT" )	;
						count			=		count.trim();
						if( ! count.equals("0") ) 
						{
							stPHAssocaited =	"Y" ;
						}						
			      }
				  out.println("setFlagForPHAssoc(\""+stPHAssocaited+"\");"); ends*/
                  result				=		true;
			}
			catch(Exception exception) {
				exception.printStackTrace();
				flag					=		"INVALID_ITEM_CODE";
				result					=		false;
							}
		}
		else if(validate.equals("EXPIRY")) {
			String expiry_yn			=		request.getParameter("expiry_yn");
			bean.setExpiry_yn(expiry_yn);
		}
		else if(validate.equals("BATCH_DETAILS")) {
			Hashtable hash				=		(Hashtable) XMLobj.parseXMLString(request);
		    hash						=		(Hashtable) hash.get ("SEARCH");
			String date					=		"";
			int batchCount				=		Integer.parseInt(request.getParameter("batchCount"));
			
			bean.setBatchReload(bean.checkForNull((String)request.getParameter("batchchange")));
			bean.setALBatchChangedData(hash);
			for(int i=0;i<batchCount;i++) {
				date=(String)hash.get("expiry_date_or_receipt_date"+i);
				bean.updateBatchDetails(i,date);
			}  			
		}
		else if(validate.equals("BARCODE")) {//Added for GHL-CRF-0413 starts
			String barcode			=		request.getParameter("barcode");
			String item_code1="";
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
			try{
				if(barcode_2d_applicable_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.6
					 item_code1  =bean.get2DBarcodeItem("",barcode);
				}else{//Adding end for MMS-DM-CRF-0174.6
				     item_code1=	(String)bean.fetchRecord("select item_code from st_item_batch where barcode_id =?",new String[]{barcode}).get("ITEM_CODE");
				item_code1 = bean.checkForNull(item_code1, "");
				}
				String item_desc1=	(String)bean.fetchRecord("select short_desc from mm_item where item_code =?",new String[]{item_code1}).get("SHORT_DESC");
				item_desc1 = bean.checkForNull(item_desc1, "");
				//Added for IN:073899 start
				if(!item_desc1.equals("")&&item_desc1!=null){
					item_desc1=item_desc1.replaceAll(" ","%20");
					item_desc1=	java.net.URLEncoder.encode(item_desc1,"UTF-8");
					item_desc1=item_desc1.replaceAll("%2520","%20");
				}
				//Added for IN:073899 start
				if(item_desc1.length() <= 0){
					result = false;
				}
				else
					result = true;
				out.println("document.getElementById('item_desc').value = decodeURIComponent('"+item_desc1+"');");//Modified for IN:073899 
				out.println("document.getElementById('item_code').value = '"+item_code1+"'");//Modified for IN:073900
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}//Added for GHL-CRF-0413 ends
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage(); 
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean("ChangeExpiryFlagBean",bean,request);

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
