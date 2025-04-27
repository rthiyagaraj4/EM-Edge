package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eOH.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOH.*;
import eOH.Common.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __mtlinkcomponentdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/MTLinkComponentDetailForm.jsp", 1742903361625L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\'javascript\' src=\'../js/OrderSet.js\'></script>\n    <script language=\'javascript\' src=\'../../eOH/js/MTasksLink.js\'></script>\n\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n\n\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\n</head>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"detailLowerForm\" id=\"detailLowerForm\" >\n<input type=\"hidden\" name=\"selAlphabet\" id=\"selAlphabet\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >\n\n<table align=\'right\' border=0>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<br><br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnHeader\'  width=\"30%\" align=\"center\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"columnHeader\" width=\'30%\' align=\"center\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</table>\n\t\t</center>\n\t\t<br><center>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"totalSelected\" id=\"totalSelected\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t<input type=\"hidden\" name=\"modified_flag\" id=\"modified_flag\" value=\"false\" >\n\t\t<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n\t\t<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t<input type=\"hidden\" name=\"sel\" id=\"sel\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t<input type=\"hidden\" name=\"treatment_code\" id=\"treatment_code\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t\n\t\t<input type=\"hidden\" name=\"task_desc\" id=\"task_desc\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t<input type=\"hidden\" name=\"task_code\" id=\"task_code\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t<input type=\"hidden\" name=\"seq_no1\" id=\"seq_no1\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t<input type=\"hidden\" name=\"multiple_yn\" id=\"multiple_yn\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t<input type=\"hidden\" name=\"maxRecord\" id=\"maxRecord\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\"hidden\" name=\"bean_mt_id\" id=\"bean_mt_id\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\"hidden\" name=\"bean_mt_name\" id=\"bean_mt_name\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\'hidden\' name=\'tabType\' id=\'tabType\' value=\"C\" >\n\t\t<input type=\'hidden\' name=\'nextPrevFlag\' id=\'nextPrevFlag\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >\n\t\t<input type=\'hidden\' name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t\t<input type=\'hidden\' name=\'detailPageMode\' id=\'detailPageMode\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' >\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\n     </center>\n\t\t\n\n\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</form>\n</body>\n<!-- <script>\n\tshowIncluded(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\n</script> -->\n</html>\n\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );
	
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

 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

    Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_mt_id		= "@MTLinkBean";
	String bean_mt_name	= "eOH.MTLinkBean";
	MTLinkBean bean_mt= (MTLinkBean)mh.getBeanObject( bean_mt_id, request, bean_mt_name );
	HashMap checkedRow=(HashMap)bean_mt.getCheckedRow();
	HashMap checkedMap=(HashMap)bean_mt.getCheckedMap();
	
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	String classValue ="";
	String nextPrevFlag		= eOR.Common.ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	String order_category	= request.getParameter("order_category");  	
	String selAlphabet	= request.getParameter("selAlphabet");  
    String from = checkForNull(request.getParameter( "from" )) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
    String treatment_code=checkForNull(request.getParameter("treatment_code"));
    
    String multiple_yn=checkForNull(request.getParameter("multiple_yn"));
    String totalSelected=request.getParameter("totalSelected");
    String select_value="Y";
    String task_code = "";
    String task_desc = "";
    String seq_no = checkForNull(request.getParameter("seq_no"));
    String mode="";
    String sel="";
    String select_checked="";
    
	int start = ( from.equals("") )?1:Integer.parseInt(from);
    int end =  ( to.equals("") )?7:Integer.parseInt(to);
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rst=null;
	String strsql="";
	StringBuffer sqlBuffer = new StringBuffer();
	
	 if(!selAlphabet.equals("Others")){
		 //commented by parul on 02/08/2010 for 23013
	  //strsql="SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE   A.TASK_CODE LIKE UPPER('"+selAlphabet+"%')AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ?   AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ?  AND TASK_CODE LIKE UPPER('"+selAlphabet+"%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";
	 strsql="SELECT   A.TASK_CODE, B.TASK_DESC, SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE UPPER(B.TASK_DESC) LIKE  UPPER('"+selAlphabet+"%') AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ? AND A.TRMT_CODE = ? UNION SELECT   TASK_CODE, TASK_DESC, NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ? AND UPPER(TASK_DESC) LIKE  UPPER('"+selAlphabet+"%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";


	 }
	 else if(selAlphabet.equals("Others")){    

		  //sqlBuffer.append("SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE   A.TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ?   AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ?  AND TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2");

		   //Added by Anitha J on 9/09/2010 for IN023771
		   strsql="SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE   A.TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ?   AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ?  AND TASK_CODE NOT BETWEEN UPPER('A%') AND UPPER('_Z%') AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";


	 }

			int maxRecord = 0;
			int i=1;
			try{
		   		conn  =  ConnectionManager.getConnection(request);
				
				pstmt = conn.prepareStatement(strsql);
					

				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,treatment_code);
				rst = pstmt.executeQuery();
				int total=0;
				while(rst.next()){
					total++;
				}
				maxRecord = total;
				

				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				pstmt=conn.prepareStatement(strsql);
				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,treatment_code);
				rst = pstmt.executeQuery();
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(selAlphabet));
            _bw.write(_wl_block11Bytes, _wl_block11);

					if ( !(start <= 1) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
					if ( !( (start+7) > maxRecord ) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
				
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 //if(maxRecord != 0){
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				rst.next() ;
				//String classValue= " ";
				int k=0;
				while ( rst.next() && i<=end  ){
                
			
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
					task_code = checkForNull(rst.getString(1));
					task_desc= checkForNull(rst.getString(2));
					seq_no= checkForNull(rst.getString(3));
					
					
					if(!(seq_no.equals("") && seq_no.equals("null") && seq_no.equals(null))){
						mode = "update";
					}
					else{
						mode = "";
					}
					
					sel=checkForNull(rst.getString(4));
					if (sel.equals("Y")){
						   select_checked="checked";
						   select_value="Y";
							k++;
					}else{
						select_checked="";
						select_value="N";
					}
					
					for(int l=0;l<checkedRow.size();l++)
					{
					if(checkedRow.containsKey(selAlphabet)==true)
						{
						 if(checkedMap.containsKey(task_code)==true)
							{
							seq_no=(String)checkedMap.get(task_code);
							select_checked="checked";
						    select_value="Y";
							}
						 else
							{
							 select_checked="";
						     select_value="N";
							}
						}
					}
					out.println("<tr>");
					out.println("<td class='" + classValue+"' width='30%'>"+task_code+"</td>");
				    out.println("<td class='" + classValue+"' width='30%'>"+task_desc+"</td>");
					out.println("<td class='" + classValue+"' width='20%'><input type='text' name='seq_no"+i+"' id='seq_no"+i+"' size='3' maxlength='3' value='"+seq_no+"' task_code='"+task_code+"'task_desc='"+task_desc+"' seq_no='"+seq_no+"'selAlphabet='"+selAlphabet+"' select_yn='"+select_value+"' db_change_seq_yn='N' value_yn='"+seq_no+"' mode='"+mode+"' onBlur=\"return validateSeqNo(this,'"+i+"')\"; onKeyPress='return allowNumOnly(event);'></td>");
			
			
					out.println("<td class='" + classValue+"' width='30%'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" task_code='"+task_code+"'task_desc='"+task_desc+"'sel='"+sel+"'selAlphabet='"+selAlphabet+"' db_change='N' seq_no='"+seq_no+"' select_yn='"+select_value+"' mode='"+mode+"' onclick=\" setCheckedRow(this);removeCheckedRow(this);\">");
				    
			
					out.println("</td>");
					out.println("</tr>");
					if(totalSelected!=null && !totalSelected.equals(null) && totalSelected.length()>0){
						//out.println("totalSelected:=="+totalSelected);
						//out.println("<script>clearListItemValue("+i+");</script>");
						String tokens[] = totalSelected.split(",");
						for(int p = 0;p<tokens.length;p++){
							if(Integer.parseInt(tokens[p])==i){
								// out.println(request.getParameter("chk_select"+i));
								out.println("<script>assingListItemValue("+tokens[p]+");</script>");
							}
						}
					}
				 
                 	i++;
				}

				//}
			
            _bw.write(_wl_block15Bytes, _wl_block15);
 
		   }catch(Exception e){
				out.println("MTasksLinkDetailForm============= : "+e);
				e.printStackTrace();
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(totalSelected));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(end));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(select_checked));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(treatment_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(task_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(multiple_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean_mt_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean_mt_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nextPrevFlag));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean.getDetailPageMode()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);


		//putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TaskCode.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.TaskDescription.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SeqNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
