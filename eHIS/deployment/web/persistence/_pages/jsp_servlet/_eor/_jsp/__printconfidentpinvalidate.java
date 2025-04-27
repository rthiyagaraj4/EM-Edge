package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __printconfidentpinvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PrintConfidentPinValidate.jsp", 1732083970000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           									created
17/11/2015		IN057113		Karthi											ML-MMOH-CRF-0335 - IN057113  								 
26/11/2015		IN058533		Karthi											System does not prompt for PIN in Record Charts Function	
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
	
	String validate = request.getParameter( "p_validate" ) == null?"":request.getParameter( "p_validate" ) ;
	String localeName = request.getParameter( "p_localeName" ) == null?"":request.getParameter( "p_localeName" );
	String patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	String encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");
	String order_id = request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id"); 
	String accession_num = request.getParameter("p_accession_num")==null?"":request.getParameter("p_accession_num"); 
	String print_req_from =request.getParameter("p_print_req_from")==null?"":request.getParameter("p_print_req_from");
	String event_code = request.getParameter("p_chart_id")==null?"":request.getParameter("p_chart_id"); //IN058533
	
	try {
		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	    Connection con = null;
	    PreparedStatement pStatement = null;
	    String selectQuery = null;
	    ResultSet resultSet = null;
	    int noOfRecsSelected = 1;
	    String multi_accession_nos = "";
	    if(print_req_from.equals("CEH_MULTI_PRINT")){
	    	eCA.PatientBannerGroupLine manageEmailBean = null;
	    	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
	    	ArrayList keyList = manageEmailBean.returnList2();
	    	if(keyList != null){
	    		noOfRecsSelected = keyList.size();	
	    		Iterator iterator = keyList.iterator();
	    		String itrValues = "";
	    		while(iterator.hasNext()) {
		    		itrValues = (String)iterator.next();
		    		
		    		StringTokenizer st = new StringTokenizer(itrValues);
		    		int i=0;
		    		String stTokens = "";
		    		while(st.hasMoreTokens()) {
		    			stTokens = st.nextToken("`");
		    			System.out.println(" MY VALUE " + stTokens);
		    			if(i==3){
		    				multi_accession_nos = stTokens+"|"+multi_accession_nos;
		    			}
		    			i++;
		    		}
		    	//	multi_accession_nos = multi_accession_nos+"|" ;
		    		
	    		}
	    		if(multi_accession_nos != "" && multi_accession_nos != null){
	    			multi_accession_nos = multi_accession_nos.substring(0,(multi_accession_nos.length()-1));
	    		}
	    		accession_num = multi_accession_nos;
	    	}
	    }
		if ("CONF_PIN_VALIDATE".equals(validate)) {
			String pinRequired =  "N";
			try {
				if(noOfRecsSelected > 0){
					selectQuery = "SELECT CA_CONF_EVENT_PIN_REQ(?, ?, ?)PINREQUIRED FROM DUAL";
					con = ConnectionManager.getConnection();
					pStatement = con.prepareStatement(selectQuery);
					pStatement.setString(1, accession_num);
					pStatement.setString(2, order_id);
					pStatement.setString(3, event_code); //IN058533
					resultSet = pStatement.executeQuery();
					while(resultSet.next()) {
						pinRequired = resultSet.getString("PINREQUIRED");
					}
				}
			} catch(Exception ex){
				System.out.println(" Exception in PrintConfidentPinValidate.jsp => " + ex.getMessage());
				ex.printStackTrace();
			} finally {
				
			}

			out.println( "isPinForPrintRequired(\"" + pinRequired  + "\") ; " ) ;
		} 
	} catch(Exception ex) {
		System.out.println("Exception in PrintConfidentPinValidate.jsp => " + ex.getMessage());
		ex.printStackTrace();
	}
	//putObjectInBean(bean_id,beanObj,request);

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
