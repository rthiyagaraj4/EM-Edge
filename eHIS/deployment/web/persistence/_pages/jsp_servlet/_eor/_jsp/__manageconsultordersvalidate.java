package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import webbeans.eCommon.MessageManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __manageconsultordersvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ManageConsultOrdersValidate.jsp", 1732512960000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t \n\t\n";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
/*
-----------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN063669		Raja S			10/3/2017	    Ramesh G		GHL-SCF-1165  
-----------------------------------------------------------------------------------------------------------------------------------------------------
*/
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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

	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Properties	p	=	(java.util.Properties) session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String facility_id = (String)session.getValue("facility_id");
		String user_id 	=	(String) session.getValue("login_user");
		String client_ip_address = p.getProperty("client_ip_address")==null?"":(String)p.getProperty("client_ip_address");
		ManageConsultOrders ManageConsOrders = (ManageConsultOrders)getObjectFromBean("Or_ManageConsOrders","eOR.ManageConsultOrders",session);	
		ManageConsOrders.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		String callFrom =(String) hash.get("CallFrom");
		String  returnVal  = "";
		if((callFrom.equals("SAVE_CONSULT_GRP"))||(callFrom.equals("UPDATE_CONSULT_GRP")))
		{	
			Boolean flag = true;
			String errorMsg = "";
			String called_from = (String)hash.get("CALLED_FROM");	
			String encounter_id = (String)hash.get("ENCOUNTER_ID");				//"home_required_yn=Y&menu_id=MED_DFLT&module_id=OR&function_id=MAN_CONS_ORDER&function_name=Manage Consult Order&function_type=F&access=YYYNN&desktopFlag=N";
			String queryString ="called_from="+called_from+"&encounter_id="+encounter_id;
			hash.put("ADDED_BY_ID",user_id);
			hash.put("ADDED_AT_WS_NO",client_ip_address);
			hash.put("ADDED_FACILITY_ID",facility_id);		

			String mode = (String)hash.get("MODE");	
			String row_ids	= (String)hash.get("ROW_IDS");
			String speciality_codes	= (String)hash.get("SPECIALITY_CODES");
			String practitioner_ids	= (String)hash.get("PRACTITIONER_IDS");
			String locns	= (String)hash.get("LOCNS");
			String consult_dates	= (String)hash.get("CONSULT_DATES");
			String fm_val	= (String)hash.get("FROM");
			String to_val	= (String)hash.get("TO");
			int fm_value = Integer.parseInt(fm_val);
			int to_value = Integer.parseInt(to_val);


			StringTokenizer rowidStoken = new StringTokenizer(row_ids,"~");
			StringTokenizer specialityCodes = new StringTokenizer(speciality_codes,"~");
			StringTokenizer practitionerIds = new StringTokenizer(practitioner_ids,"~");
			StringTokenizer locnStoken = new StringTokenizer(locns,"~");
			StringTokenizer consultDates = new StringTokenizer(consult_dates,"~");

			Hashtable tabdata = new Hashtable();
			//HashMap dataMap = new HashMap();
			String row_id = "";
			String speciality = "";
			String practitionerId = "";
			String locn = "";
			String consultDate = "";
			

			for(int j=fm_value; j<to_value; j++)
			{
				int change = 0;
				if(rowidStoken.hasMoreTokens()) 
				{
					row_id			=	 (rowidStoken.nextToken()).trim();
					if(row_id.equals("@#"))
						row_id		=	 "";
				}
				else 
				{
					row_id			=	 "";
				}

				if(specialityCodes.hasMoreTokens()) 
				{
					speciality			=	 (specialityCodes.nextToken()).trim();
					if(speciality.equals("@#"))
						speciality		=	 "";
				}
				else 
				{
					speciality			=	 "";
				}

				if(practitionerIds.hasMoreTokens()) 
				{
					practitionerId			=	 (practitionerIds.nextToken()).trim();
					if(practitionerId.equals("@#"))
						practitionerId		=	 "";
				}
				else 
				{
					practitionerId			=	 "";
				}

				if(locnStoken.hasMoreTokens()) 
				{
					locn			=	 (locnStoken.nextToken()).trim();
					if(locn.equals("@#"))
						locn		=	 "";
				}
				else 
				{
					locn			=	 "";
				}

				if(consultDates.hasMoreTokens()) 
				{
					consultDate			=	 (consultDates.nextToken()).trim();
					if(consultDate.equals("@#"))
						consultDate		=	 "";
				}
				else 
				{
					consultDate			=	 "";
				}
				String[] record = (String[])ManageConsOrders.getDataMapValues(row_id);
				
				if(!consultDate.equals((String)record[12]))
				{
					record[12] = consultDate;
					++change;
				}
				if(!locn.equals((String)record[10]))
				{
					record[10] = locn;
					++change;
				}
				if(!practitionerId.equals((String)record[8]))
				{
					record[8] = practitionerId;
					++change;
				}
				if(!speciality.equals((String)record[6]))
				{
					record[6] = speciality;
					++change;
				}
				if(change>0)
				{
					record[18] = "C";
					ManageConsOrders.setDataMap(row_id,record);
				}
			}
			
			if((callFrom.equals("SAVE_CONSULT_GRP")))
			{
				returnVal = (String)ManageConsOrders.insert(hash);	
		
				if(returnVal.equals("TRANS_SUCCESS"))
				{
					//IN063669 Changes Starts
					//out.println("parent.ManageConsultOrderdtl.location.href='../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString +"'");//Commented for IN063669
					//out.println("parent.ManageConsultOrderbtn.location.href='../../eOR/jsp/ManageConsultOrdersButton.jsp?"+queryString +"'");//Commented for IN063669  
					//IN063669 Changes Ends
					tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					errorMsg = (String) tabdata.get("message");	
					//IN063669 Changes Starts
					//out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); //Commented for IN063669
					out.println("alert('"+errorMsg+"');window.close()"); //Added for IN063669					
					//IN063669 Changes Ends
				}
				else if(returnVal.equals("") || returnVal.equals("TRANS_FAILED"))
				{
					//out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderdtl.location.href='../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderbtn.location.href='../../eOR/jsp/ManageConsultOrdersButton.jsp?"+queryString +"'");  
					tabdata = MessageManager.getMessage(locale, "OPERATION_FAILED","OR");
					errorMsg = (String) tabdata.get("message");		
					out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
				}
				else if(returnVal.equals("") && returnVal.equals("NO_CHANGES_TO_SAVE"))
				{
					//out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderdtl.location.href='../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderbtn.location.href='../../eOR/jsp/ManageConsultOrdersButton.jsp?"+queryString +"'");  
					tabdata = MessageManager.getMessage(locale, "NO_CHANGES_TO_SAVE","Common");
					errorMsg = (String) tabdata.get("message");		
					out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
				}
			}
		}				
		putObjectInBean("Or_ManageConsOrders",ManageConsOrders,session);
	}catch(Exception e){
		e.printStackTrace();	
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
