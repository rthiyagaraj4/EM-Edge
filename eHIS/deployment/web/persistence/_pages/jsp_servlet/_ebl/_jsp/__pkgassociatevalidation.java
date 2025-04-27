package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eBL.Common.*;
import eBL.*;
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

public final class __pkgassociatevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgAssociateValidation.jsp", 1739259203603L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

Connection con			= ConnectionManager.getConnection();	
String bean_id		= "PkgAssociateBean" ;
String bean_name	= "eBL.PkgAssociateBean";
PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;

String bean_id1		= "PkgApprovalBean" ;
String bean_name1	= "eBL.PkgApprovalBean";
PkgApprovalBean bean1			= (PkgApprovalBean)getBeanObject( bean_id1, bean_name1, request ) ;

try {
	request.setCharacterEncoding("UTF-8");

	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;	
	bean.setLanguageId(locale);		
	String	func_mode	= request.getParameter( "func_mode" );	
	if(func_mode != null && func_mode.equals("saveToBean" ) )
	{			
		String	total_records		=	(String) hash.get( "total_records" );
		ArrayList associatedPkgs=new ArrayList();
		int totalRec				=	Integer.parseInt(total_records);
		String associated="";
		bean.setAssociatedPkgs(new ArrayList());// clear the bean first

		for(int i=0;i<totalRec; i++)
		{
	   	   associated = (String) hash.get( "associated"+i );
		   
		   if(associated != null && associated.equals("Y"))
		   {
			associatedPkgs.add(((String)hash.get( "pkg_code"+i )==null?"":(String)hash.get( "pkg_code"+i ))+"~~"+((String)hash.get( "pkg_desc"+i )==null?"":(String)hash.get( "pkg_desc"+i ))+"~~"+((String)hash.get( "pkg_seq_no"+i )==null?"":(String)hash.get( "pkg_seq_no"+i ))+"~~"+((String)hash.get("from_date"+i)==null?" ":(String)hash.get("from_date"+i))+"~~"+((String)hash.get("pkgAmt"+i)==null?"":(String)hash.get("pkgAmt"+i)));			 
		   	System.out.println("associatedPkgs "+associatedPkgs.toString());
		   	//System.out.println("pkg amt "+(String)hash.get("pkgAmt"+i));
		   }
		}
		bean.setAssociatedPkgs(associatedPkgs);// set associated pkg in the bean
		System.out.println(" bean get  "+bean.getAssociatedPkgs());
	}else if(func_mode != null && func_mode.equals("chkPkgApprovals" ) ){
		String pkg_code=(String) hash.get( "pkg_code" );
		String pkg_desc=(String) hash.get( "pkg_desc" );
		String pkg_seq_no=(String) hash.get( "pkg_seq_no" );
		String calling_module_id = (String) hash.get( "calling_module_id" );
		String index=(String) hash.get( "index" );
		ArrayList apprvdPkgsList=bean1.getApprvdPkgsList();
		if(apprvdPkgsList.contains(""+pkg_code+"~~"+pkg_desc+"~~"+pkg_seq_no)){
			out.println("alert(getMessage('BL8610','BL'));eval(document.PkgAssociateDtl.associated"+index+").checked=true;eval(document.PkgAssociateDtl.associated"+index+").value='Y'");
		}
	}else if(func_mode != null && func_mode.equals("chkPkgvalidepisode" ) )
	{

		String pkg_code=(String) hash.get( "pkg_code" );
		String pkg_seq_no=(String) hash.get( "pkg_seq_no" );

		String allPayerGroupCode=(String) hash.get( "allPayerGroupCode" );
		String allPayerCode=(String) hash.get( "allPayerCode" );
		boolean errorFound=false;
		String calling_module_id = (String) hash.get( "calling_module_id" );
		String index=(String) hash.get( "index" );	
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		//Karthik added code for MMS-RY-SCF-0065 - This validation is to Verify whether the Payer for Package Association is present as Financial Information
 		if( allPayerGroupCode!=null && allPayerGroupCode.equals("")==false && allPayerGroupCode.equals("null")==false ){
 			//Modified dynamic construction of Sql by Rajesh V
 			String sql="SELECT COUNT (*) FROM bl_package_sub_hdr WHERE operating_facility_id =?  AND package_code =?  AND package_seq_no =? AND ((cust_group_code IS NOT NULL AND cust_group_code IN (";
 			StringTokenizer custGroupToken = new StringTokenizer(allPayerGroupCode,",");
 			int tokenCnt = 0;
 			List<String> custGroupList = new LinkedList<String>();
 			while(custGroupToken.hasMoreTokens()){
 				if(tokenCnt == 0){
 					sql = sql+"?";
 				}
 				else{
 					sql = sql+",?";
 				}
 				custGroupList.add(custGroupToken.nextToken());
 				tokenCnt++;
 			}
 			sql = sql + ")) OR (cust_group_code IS NULL) )";

			String strCount="";//BLHelper.getDescriptionViaSQL(con,sql,facility_id,pkg_code,pkg_seq_no,allPayerGroupCode);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, pkg_code);
			pstmt.setString(3, pkg_seq_no);
			int inPos = 4;
			for(String inElements:custGroupList){
				pstmt.setString(inPos, inElements);
				inPos++;
			}
			rst = pstmt.executeQuery();
			
			if(rst != null && rst.next()){
				strCount = rst.getString(1);
			}
			
			//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+custGroupList);
			//System.err.println("First Block Count->"+strCount);
			int count=Integer.parseInt(strCount);
			if(count==0){
				out.println("alert('Payer Group associated with Package is not present in Financial Details');");
				errorFound=true;
				//Added by Rajesh V for 5475
				out.println("eval(document.PkgAssociateDtl.associated"+index+").checked=false;eval(document.PkgAssociateDtl.associated"+index+").value='N'");
			}
		} 
		
 		if(errorFound==false && allPayerCode!=null && allPayerCode.equals("")==false && allPayerCode.equals("null")==false ){
 			//Modified dynamic construction of Sql by Rajesh V
 			String sql="SELECT COUNT (*) FROM bl_package_sub_hdr WHERE operating_facility_id =?  AND package_code =?  AND package_seq_no =? AND ((cust_code IS NOT NULL AND cust_code IN (";
			StringTokenizer custToken = new StringTokenizer(allPayerCode,",");
 			int tokenCnt = 0;
 			List<String> custList = new LinkedList<String>();
 			while(custToken.hasMoreTokens()){
 				if(tokenCnt == 0){
 					sql = sql+"?";
 				}
 				else{
 					sql = sql+",?";
 				}
 				custList.add(custToken.nextToken());
 				tokenCnt++;
 			}
 			sql = sql + ")) OR (cust_code IS NULL) )";
			String strCount="";//BLHelper.getDescriptionViaSQL(con,sql,facility_id,pkg_code,pkg_seq_no,allPayerCode);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, pkg_code);
			pstmt.setString(3, pkg_seq_no);
			int inPos = 4;
			for(String inElements:custList){
				pstmt.setString(inPos, inElements);
				inPos++;
			}
			rst = pstmt.executeQuery();
			
			if(rst != null && rst.next()){
				strCount = rst.getString(1);
			}
			//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+custList);
			//System.err.println("Second Block Count->"+strCount);
			int count=Integer.parseInt(strCount);
			if(count==0){
				out.println("alert('Payer associated with Package is not present in Financial Details');");
				errorFound=true;
				//Added by Rajesh V for 5475
				out.println("eval(document.PkgAssociateDtl.associated"+index+").checked=false;eval(document.PkgAssociateDtl.associated"+index+").value='N'");

			}
		} 


		if(errorFound==false && bean.pkgDefinedValidPatClass(facility_id,calling_module_id,pkg_code)==false)
		{	
		out.println("alert(getMessage('BL8688','BL'));eval(document.PkgAssociateDtl.associated"+index+").checked=false;eval(document.PkgAssociateDtl.associated"+index+").value='N'");
		}
		
	}

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgAssociationValidation.jsp="+e);
}finally
{
	ConnectionManager.returnConnection(con, request);
}
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id1,bean1,request);


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
