package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.Common.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __privilegequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PrivilegeQueryResult.jsp", 1709119944000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="  \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script>\n\tfunction Modify(obj){\n\t\t/*var appl_user_id = obj.cells[0].innerText;\n\t\tvar facility_id = obj.cells[5].innerText;\n\t\tvar reln_id = obj.cells[7].innerText;\n\t\tvar resp_id = obj.cells[9].innerText;*/\n\n\t\t//var privilege_ctx_id = obj.cells[9].children[0].value;\n\t\tvar privilege_ctx_id = obj.cells[8].innerText;\n\t\n\t\t//var privilege_ctx_id = obj.cells[12].innerText;\n\t\t//alert(privilege_ctx_id);\n\t\t//modified by Subhash.Y on 6th May 2004 actual value cells[12]\n\t\t//alert(privilege_ctx_id);\n\t\t//document.location.href=\"../../eOR/jsp/PrivilegeAddModify.jsp?mode=2&privilege_ctx_id=\"+privilege_ctx_id+\"&function_id=\"+parent.function_id+\"&appl_user_id=\"+appl_user_id+\"&facility_id=\"+facility_id+\"&reln_id=\"+reln_id+\"&resp_id=\"+resp_id;\n\t\tdocument.location.href=\"../../eOR/jsp/PrivilegeAddModify.jsp?mode=2&privilege_ctx_id=\"+privilege_ctx_id+\"&function_id=\"+parent.function_id;\n}\n</script>\n\n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t<title></title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\n\t\t<!--<script language=\"JavaScript\" src=\"../js/Privilege.js\"></script>-->\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body onMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>//alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t\t<table cellpadding=3 cellspacing=0 width=\"100%\" align=center>\n\t\t<tr>\n\t\t<td class=label></td>\n\t\t<td class=label>  \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</td></tr>\n\t\t</table>  \n\n\t\t<table border=\"1\" cellpadding=3 cellspacing=0 width=\"104%\" align=center>\n\t\t<tr>\n\t\t<td class=columnheader>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=columnheader>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td class=columnheader nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td> \n\t\t<td class=columnheader>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t</tr>\n\n\t\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<tr onClick=\"Modify(this);\" >\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<!--\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onclick=\"disableClick(event);\" nowrap>\n\t\t\t<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" name=\"privilege_ctx_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></td> \n\t\t\t-->\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  onmouseover=\"changeCursor(this);\"><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onclick=\"disableClick(event);\" nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td width=\"0\" style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t  </tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t\t\t\t</table>\t\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	//Search Criteria's from Query Criteria page
	request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String privilege_value	= CommonBean.checkForNull(request.getParameter("privilege_value"));
	String privilege_ctx_id		= CommonBean.checkForNull(request.getParameter("privilege_ctx_id"));
	String privilege_ctx		= CommonBean.checkForNull(request.getParameter("privilege_ctx"));
	String privilege_id			= CommonBean.checkForNull(request.getParameter("privilege_id"));
	String facility_id			= CommonBean.checkForNull(request.getParameter("facility_id"));
	String facility_name		= CommonBean.checkForNull(request.getParameter("facility_name"));
	String appl_user_id 		= 
	CommonBean.checkForNull(request.getParameter("appl_user_id"));
	//out.println("appl_user_id"+appl_user_id);
	String appl_user_name		= CommonBean.checkForNull(request.getParameter("appl_user_name"));
	String reln_id				= 
	CommonBean.checkForNull(request.getParameter("reln_id"));
	String pract_reln_name		= CommonBean.checkForNull(request.getParameter("pract_reln_name"));
	String resp_id				=
	CommonBean.checkForNull(request.getParameter("resp_id"));
	String resp_name			=
	CommonBean.checkForNull(request.getParameter("resp_name"));
	//String active_yn			=
	//CommonBean.checkForNull(request.getParameter("active_yn"));
	
	String bean_id = "privilege" ;
	String bean_name = "eOR.PrivilegeBean";
	/*System.out.println("#####hashTemp values in privilegeQueryResult page");
	 System.out.println("#####privilege_value="+privilege_value);
	 System.out.println("#####privilege_ctx_id="+privilege_ctx_id);
	 System.out.println("#####privilege_ctx="+privilege_ctx);
	 System.out.println("#####privilege_id="+privilege_id); System.out.println("#####facility_id="+facility_id);
	 System.out.println("#####facility_name="+facility_name);
	 System.out.println("#####appl_user_id="+appl_user_id);
	 System.out.println("#####appl_user_name="+appl_user_name);
	 System.out.println("#####reln_id="+reln_id);
	 System.out.println("#####pract_reln_name="+pract_reln_name);
	 System.out.println("#####resp_id="+resp_id);
	 System.out.println("#####resp_name="+resp_name);*/
	  

	HashMap hashTemp = new HashMap();
	hashTemp.put("privilege_value",privilege_value +"%");
	hashTemp.put("privilege_ctx_id",privilege_ctx_id +"%");
	hashTemp.put("privilege_ctx",privilege_ctx +"%");
	hashTemp.put("privilege_id",privilege_id +"%");
	hashTemp.put("facility_id",facility_id +"%");
	hashTemp.put("facility_name",facility_name +"%");
	hashTemp.put("appl_user_id",appl_user_id +"%");
	hashTemp.put("appl_user_name",appl_user_name +"%");
	hashTemp.put("reln_id",reln_id +"%");
	hashTemp.put("pract_reln_name",pract_reln_name +"%");
	hashTemp.put("resp_id",resp_id +"%");
	hashTemp.put("resp_name",resp_name +"%");
	//hashTemp.put("active_yn",active_yn +"%");
	//out.println("#####hashTemp="+hashTemp);
	 
	  

	/* Required while Selecting sql and Formatting display*/
	//String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	//String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;
	//String valSource[]  ={"U","R","P"} ;
	//String descsource[]={"User Id","RelationShip","Responsibilty"} ;
	//String descsource[]={"Application User","Relationship","Responsibility"} ;
	//String valSourceVal[]  ={"S","M","A","N"} ;//modified by Kavitha.K 1/10/2005
	//String descsourceVal[]={"Allowed","Not Allowed","Allowed with Exception","Not Allowed with Exception"} ;//removed by Kavitha.K 1/10/2005
	//String valSourcePrivilege[]  ={"O"} ;
	//String descsourcePrivilege[]={"Order"} ;
	//String valSourcePrivilege[]  ={"O","C","A","H","D","U","S","P","V"} ;
	//String descsourcePrivilege[]={"Order","Cancel","Amend","Hold/Resume","Discontinue","Order Authorizaiton","Cosign","Special Approval","View"} ;
			
	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null? false : true  ;
	
	 //String sql = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_QUERYCRITERIA");	
	 //String sql1 = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_DISTINCT_CTX_QUERY");	
	 
	
try{
	String classvalue			= "";
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_QUERYCRITERIA"));
//out.println(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_QUERYCRITERIA"));
	//HashMap sqlMap1 = new HashMap();
	//include all the common parameters.
	//sqlMap.put( "sqlData",sql);

	//Function Parameters
	HashMap funcMap = new HashMap();
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	ArrayList chkFields = new ArrayList();

	PrivilegeBean bean = (PrivilegeBean)getBeanObject( bean_id,  bean_name, 	request ) ;  
	bean.clear() ;	
	
	//Vector privList = bean.getDistPrivilegeCtxID(hashTemp);
	//System.err.println("Vector @@@@@ " + privList);
	//System.err.println("Vector size @@@ " + privList.size());
	//System.out.println("#####privList.size()="+privList.size());
	//System.out.println("#####privList="+privList);
	/*if(privList.size() == 0)
	{*/
	
            _bw.write(_wl_block11Bytes, _wl_block11);

	//}	
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		
	/*for(int i=0;i<privList.size();i++)
	{*/

	displayFields = new ArrayList();

	displayFields.add( "appl_user_id" );
	displayFields.add( "appl_user_name" );
	//displayFields.add( "privilege_ctx" );
	//displayFields.add( "privilege_id" );
	//displayFields.add( "privilege_value" );
	displayFields.add( "facility_id" );
	displayFields.add( "facility_name" );
	displayFields.add( "reln_id" );
	displayFields.add( "pract_reln_name" );
	displayFields.add( "resp_id" );
	displayFields.add( "resp_name" );
	//displayFields.add( "active_yn" );
	displayFields.add( "privilege_ctx_id" );

	//The fields are going to be in where condition * should match with the query
	//ArrayList 

	chkFields = new ArrayList();

	//chkFields.add( "%" );
	chkFields.add( privilege_ctx_id +"%");
	//chkFields.add( ((String)privList.get(i++)) +"%");
	//chkFields.add( privilege_id +"%" );
	//chkFields.add( privilege_ctx +"%" );
	chkFields.add( facility_id +"%" );
	chkFields.add( appl_user_id +"%");
	chkFields.add( reln_id  +"%");
	chkFields.add( resp_id +"%" );
	//chkFields.add( privilege_value +"%" );
	//chkFields.add( active_yn +"%" );
	chkFields.add( appl_user_name +"%");
	chkFields.add( resp_name +"%" );
	chkFields.add( facility_name +"%" );
	chkFields.add( pract_reln_name +"%");

		
/*	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%");
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
	chkFields.add( "%" );
	chkFields.add( "%" );
	chkFields.add( "%");
*/	
	
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//System.out.println("#####displayFields="+displayFields);
	//System.out.println("#####chkFields="+chkFields);
	//System.err.println("Before commonBean.query result @@@@@@@@@@@@");
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//System.err.println("After commonBean.query result @@@@@@@@@@@@");
	//System.out.println("#####result.size()="+result.size());
	//System.out.println("#####result="+result);
	
	if((result.size()>=3)  && ( !( ((String) result.get(0)).equals("0")) ) ){
	
            _bw.write(_wl_block13Bytes, _wl_block13);

		// For display the previous/next link
	     out.println(result.get(1));
		
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String str = "";
		String link_columns = "";
		String link_columns1="";
		String on_click="";
		//int recCount = 2;
		for(int recCount=2; recCount<result.size(); recCount++){
			if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
			else
			classvalue = "QRYODD" ;
		
            _bw.write(_wl_block19Bytes, _wl_block19);

			link_columns = "";
			//System.err.println("SSSSSS @@@@@ " + appl_user_id +" " + reln_id + " " + resp_id);
			/*if(appl_user_id != null && appl_user_id != "")
				link_columns = "1";
			else if(reln_id != null && reln_id != "")
					link_columns = "5";
				 else if(resp_id != null && resp_id != "")
					link_columns = "7";
			*/
			link_columns1 = "3";
			
			//records=(ArrayList) result.get( recCount );
			records=(ArrayList) result.get(recCount);
			//out.println(records);
			//out.println("records size  " + records.size());
			//System.err.println("Records   @@@@@@   " + records);  
			for(int colCount=0; colCount<records.size(); colCount++){
			//if(colCount == records.size()-1) // modified by Subhash.Y on 4th May 2004
			//	break;

			str = (String)records.get(colCount);	
			

		    //if(colCount == 2 )//to display Nurse Colllect
   			//str=eHISFormatter.chkReturn(valSource,str,descsource,"&nbsp;");

		//	if(colCount == 3 )//to display Nurse Colllect
		//	{
   				//str=eHISFormatter.chkReturn("O",str,"Order","&nbsp;");
				//System.err.println("valSourcePrivilege @@@@@@@@@@ " + valSourcePrivilege);
				//System.err.println("str @@@@@@@@@@ " + str);
				//System.err.println("descsourcePrivilege @@@@@@@@@@ " + descsourcePrivilege);

		//		str=eHISFormatter.chkReturn(valSourcePrivilege,str,descsourcePrivilege,"&nbsp;");
				//System.err.println("str @@@@@@@@@@ " + str);
		//	}

		//	if(colCount == 4 )//to display Nurse Colllect
   		//	str=eHISFormatter.chkReturn(valSourceVal,str,descsourceVal,"&nbsp;");

			//if(colCount == 11 )//to display Nurse Colllect
			//str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
			   			
		//	if(colCount == 11 )
		//	{
   			
            _bw.write(_wl_block20Bytes, _wl_block20);
//=classvalue
            _bw.write(_wl_block21Bytes, _wl_block21);
//=str
            _bw.write(_wl_block22Bytes, _wl_block22);
//=(recCount-2)
            _bw.write(_wl_block23Bytes, _wl_block23);

		//	continue;}
			if(colCount == 0 && str != null && str != "")
				link_columns = "1";
			if(colCount == 4 && str != null && str != "")
				link_columns = "5";
			if(colCount == 6 && str != null && str != "")
				link_columns = "7";
			if(str == null){ 
				str = "&nbsp;" ;
				on_click="disableClick(event);";
			}else
				on_click= "";
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 || link_columns1.indexOf(String.valueOf(colCount+1)) != -1)
				{ 
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(on_click));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(str));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
			else
			{
				if(colCount != 8)
				{
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str));
            _bw.write(_wl_block30Bytes, _wl_block30);
 }
				else
				{
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str ));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}
			}
				//}//for records from result...
			}
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);

			out.flush();
		
	} else{
	
            _bw.write(_wl_block35Bytes, _wl_block35);

	}
	//recCount++;
	//}//for loop of vector(distinct privilege ctx ids)//removed by Kavitha.K 1/27/2005

	  
            _bw.write(_wl_block36Bytes, _wl_block36);
	
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/PrivilegeQueryResult.jsp", searched));
putObjectInBean(bean_id,bean,request);
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}

            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appluserid.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApplicationUser.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityID.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RelationId.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RelationName.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.responsibility.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ResponsibilityName.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
