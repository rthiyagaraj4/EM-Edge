package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.Common.*;
import com.ehis.util.*;
import eBL.*;
import eMR.*;
import eBL.BLReportIdMapper;
import eBL.BlServiceDiscPriceBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blservicediscpricevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLServiceDiscPriceValidation.jsp", 1709114115490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

Connection con = null;
CallableStatement cstmt = null;
CallableStatement cstmt1 = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
boolean inserted = true;
String functionMode = "";
	
	try 
	{
		con = ConnectionManager.getConnection();
		functionMode = request.getParameter("functionMode");
		if (null == functionMode) {
			functionMode = "";
		}

		if("patientCategory".equals(functionMode)){			
			String patientCategory="";				
			try
			{				
				String billing_class=request.getParameter("billing_class");
				String category =	"select NVL(PATIENT_CATEGORY_CODE,'') from BL_BLNG_CLASS where BLNG_CLASS_CODE=?";
				pstmt = con.prepareStatement(category);
				pstmt.setString(1,billing_class);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					patientCategory	= rs.getString(1);
				}
				System.err.println("patientCategory====>"+patientCategory);
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(patientCategory);					
		} 
		else if("chkMMItemServYN".equals(functionMode)){			
			String isServMatItemYN="N";				
			try
			{			
				String servCode=request.getParameter("servCode");
				String servInd=request.getParameter("servInd");
				
				//Changes done for MMS-KH-SCF-0187 by Manivel N
				/* String sql = "select NVL(MM_ITEM_SERV_YN,'N') MM_ITEM_SERV_YN  from bl_blng_serv where blng_serv_code='" + servCode + "'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					isServMatItemYN = rs.getString("MM_ITEM_SERV_YN");			
				}	
				System.err.println("isServMatItemYN====>"+isServMatItemYN);
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();*/
				
				BlServiceDiscPriceBean callingObj = new BlServiceDiscPriceBean();
				isServMatItemYN = callingObj.isServMatBased(servCode,servInd);
				System.err.println("isServMatItemYN====>"+isServMatItemYN);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(isServMatItemYN);					
		}
		else if("isServiceChargeBasedYN".equals(functionMode)){
			String isServiceChargeBasedYN = "N";
			String rateChargeFlag="N";
			String materialItemYN="";

		try {
				String servCode=request.getParameter("servCode");
				pstmt = con.prepareStatement("select RATE_ENTRY_BY_USER_FLAG, MM_ITEM_SERV_YN from bl_blng_serv where blng_serv_code=? ");
				pstmt.setString(1, servCode);

				rs = pstmt.executeQuery();
				
				if (rs != null && rs.next()) {
					rateChargeFlag = (String) rs.getString("RATE_ENTRY_BY_USER_FLAG");
					materialItemYN = (String) rs.getString("MM_ITEM_SERV_YN");
					System.err.println("107===>"+materialItemYN);
				}
				System.err.println("85====>servCode===>"+servCode);
				System.err.println("rateChargeFlag===>"+rateChargeFlag);
				if(rateChargeFlag.equals("C")){
					isServiceChargeBasedYN="Y";
					System.err.println("isServiceChargeBasedYN===>"+isServiceChargeBasedYN);
				}
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();				
	
		}catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(isServiceChargeBasedYN);					
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from generatecolrpt.jsp "+e);
		con.rollback();
	}
	finally{
		ConnectionManager.returnConnection(con,request);
	} 

            _bw.write(_wl_block2Bytes, _wl_block2);
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
