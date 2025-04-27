package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgadhocdiscountvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgAdhocDiscountValidation.jsp", 1720153714799L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

String bean_id			  = "bl_PkgAdhocDiscountBean" ;
String bean_name		  = "eBL.PkgAdhocDiscountBean";
PkgAdhocDiscountBean bean = (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
Connection con = ConnectionManager.getConnection();	
PreparedStatement pstmt = null;
ResultSet rs = null;

try
{
	request.setCharacterEncoding("UTF-8");
	String func_mode			= request.getParameter("func_mode");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String	patientId		= (String) hash.get( "patientId" );	
	String	packageSeqNo	= (String) hash.get( "packageSeqNo" );	
	String	totalRec		= (String) hash.get( "totalRec" );	
	String  adhocDiscount 	= "";
	String encounterId		= "";
	String encounterId_chk	= "";

	ArrayList enconterDtls		= new ArrayList();
	ArrayList dtls				= new ArrayList();
	ArrayList dtlsNew			= null;
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/ */
	String facilityId = (String) session.getValue("facility_id");

	if(func_mode!=null && func_mode.equals("CHK_PAT_ID") )	
	{
		String str_x="";
		pstmt = con.prepareStatement( "SELECT 'X' FROM mp_patient WHERE patient_id='"+patientId+"'");			
		rs = pstmt.executeQuery();	
		while(rs!=null && rs.next())
		{
			str_x  =  rs.getString(1);
		}
		if(str_x==null) str_x="";
		if(str_x.equals("")){
		out.println("N");
		}else{
			out.println("Y");
		}
	}
	else if(func_mode.equals("SAVE_VALUES"))
	{
		int totalRecords		= Integer.parseInt(totalRec);
		ArrayList packageSeqNoList	= bean.getPackageSeqNoList();
		HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();

		if(adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
		{
			enconterDtls = 	(ArrayList)adhocDiscountDtls.get(packageSeqNo);
		}
		for(int i=0;i<totalRecords;i++)
		{
			adhocDiscount = (String) hash.get( "adhocDiscount_"+i );
			encounterId = (String) hash.get( "encounterId_"+i );
			dtls = 	(ArrayList)enconterDtls.get(i);
			encounterId_chk =(String)dtls.get(0);
//			if(adhocDiscount!=null && !adhocDiscount.equals(""))
//			{
				if(!(packageSeqNoList.contains(packageSeqNo)))
					packageSeqNoList.add(packageSeqNo);
					//enconterDtls.remove(i);
				
					dtlsNew	= new ArrayList();
					/*dtlsNew.add(encounterId);
					dtlsNew.add((String) hash.get( "blngGrpId_"+i ));
					dtlsNew.add((String) hash.get( "custGrpCode_"+i ));
					dtlsNew.add((String) hash.get( "custGrpDesc_"+i ));
					dtlsNew.add((String) hash.get( "custCode_"+i ));
					dtlsNew.add((String) hash.get( "custDesc_"+i ));
					dtlsNew.add((String) hash.get( "priority_"+i ));
					dtlsNew.add((String) hash.get( "policyTypeCode_"+i ));
					dtlsNew.add((String) hash.get( "policyNo_"+i ));
					dtlsNew.add((String) hash.get( "approvedAmt_"+i ));
					dtlsNew.add((String) hash.get( "discountAsPerSetup_"+i ));
					dtlsNew.add((String) hash.get( "episodeType_"+i )); 
					dtlsNew.add((String) hash.get( "visitId_"+i ));
					dtlsNew.add((String) hash.get( "appmtBkRefNo_"+i )); 
					dtlsNew.add((String) hash.get( "acctSeqno_"+i ));
					dtlsNew.add((String) hash.get( "episodeId_"+i ));  			 
					dtlsNew.add(adhocDiscount);
					dtlsNew.add((String) hash.get( "type_"+i ));*/
				
					dtlsNew.add((String) hash.get( "cust_group_code"+i ));
					dtlsNew.add((String) hash.get( "cust_group_desc"+i ));
				///	if(((String)hash.get( "cust_desc"+i )).equals("") ){
					//	dtlsNew.add("");
				//	}else{
					dtlsNew.add((String)hash.get( "cust_code"+i ));
				//}				
					dtlsNew.add((String) hash.get( "cust_desc"+i ));
					dtlsNew.add((String) hash.get( "discountAsPerSetup_"+i ));
					dtlsNew.add((String) hash.get( "type_"+i ));
					dtlsNew.add((String) hash.get( "adhocDiscount_"+i ));
					dtlsNew.add((String) hash.get( "to_update"+i ));					
					dtlsNew.add((String) hash.get( "packageCode" ));					
					dtlsNew.add((String) hash.get( "reason_code"+i ));
					dtlsNew.add((String) hash.get( "reason_desc"+i ));
					dtlsNew.add((String) hash.get( "del_rec_YN"+i ));
					enconterDtls.set(i,dtlsNew);
//			}

			adhocDiscountDtls.put(packageSeqNo,enconterDtls);
			bean.setAdhocDiscountDtls(adhocDiscountDtls);
			bean.setPackageSeqNoList(packageSeqNoList);

		}
	}
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/Starts */
	else if(func_mode.equals("copay_disc_valid_yn")) {
		
		packageSeqNo = request.getParameter("packageSeqNo");
		String custCode = request.getParameter("custCode");
		String custGroupCode = request.getParameter("custGroupCode");
		String episodeType = request.getParameter("episode_type");
		String episodeId = request.getParameter("episode_id");
		String packageCode = request.getParameter("packageCode");
		String visitId = request.getParameter("visit_id");
		
		String copayValidYN = "";
		
		CallableStatement cstmt = con.prepareCall("{ call bl_adhoc_disc_valid_copay_yn(?,?,?,?,?,?,?) }");
		cstmt.setString(1, facilityId);
		cstmt.setString(2, patientId);
		cstmt.setString(3, packageSeqNo);
		cstmt.setString(4, custCode);
		cstmt.setString(5, custGroupCode);
		cstmt.setString(6, episodeType);
		//cstmt.setString(7, episodeId);
		cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
		cstmt.execute();
		
		copayValidYN = cstmt.getString(7);
		
		out.print(copayValidYN);
	}
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/Ends */
}
catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgAdhocDiscountValidation :"+e);
}
finally
{	
	if(pstmt != null)		pstmt.close();
	if(rs != null)		rs.close();
	ConnectionManager.returnConnection(con, request);
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
