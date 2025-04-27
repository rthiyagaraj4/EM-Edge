package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryorderformatautidtraillist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryOrderFormatAutidTrailList.jsp", 1709119812000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n <script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n <script language=\"javascript\" src=\"../../eOR/js/ViewOrder.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<title>Audit Trail for Order Entry Format</title>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n\t<form name=\"OrderEntryFormatAuditTrailList\" id=\"OrderEntryFormatAuditTrailList\">\n\t\t<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' id=\"auditTrailList\">\t\n\t\t\t<tr>\n\t\t\t\t<th class=\'columnHeadercenter\' rowspan=2 width=\'10%\'>S.No</th>\n\t\t\t\t<th class=\'columnHeadercenter\' colspan=2 width=\'40%\'>Modified</th>\n\t\t\t\t<th class=\'columnHeadercenter\' rowspan=2 width=\'50%\'>Reason</th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<th class=\'columnHeadercenter\' widht=\'15%\'>Date</th>\n\t\t\t\t<th class=\'columnHeadercenter\' widht=\'25%\'>Practitioner Name</th>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<tr onclick=\"viewOrderFormatAuditTrail(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\" id=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t<td class=\'gridData\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:ShowComments(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="...</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\n\t\t</table>\n\t\t<script>\n\t\t\tviewOrderFormatAuditTrail(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\t\t\n\t\t</script>\n \t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
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
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
12/09/2014	IN051106		Karthi L	12/9/2014		Akbar				Amended Practitioner details displayed  as Blank at Audit trail									
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
String order_id	  = request.getParameter("orderId");
String lineId = request.getParameter("lineId")==null?"":request.getParameter("lineId" ) ;
String action_seq_num="";

            _bw.write(_wl_block8Bytes, _wl_block8);

			Connection conn  = null;
			PreparedStatement pstmt;
			ResultSet rs = null;
			String tempTable = "OR_ORDER_FIELD_VALUES_ACTION";
			if(!"".equals(lineId)){
				tempTable = "OR_ORDER_LINE_FLD_VAL_ACTION";
			}
			
			//String strsql1="SELECT DISTINCT A.ACTION_SEQ_NUM,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG WHERE PRACTITIONER_ID=A.ADDED_BY_ID AND LANGUAGE_ID=?) PRACTITIONER_NAME,SM_CONVERT_DATETIME_2T(A.ADDED_DATE,?) ADDED_DATE, A.ORDER_AMEND_REASON FROM OR_ORDER_AMEND_REASON A INNER JOIN "+tempTable+" B ON A.ACTION_SEQ_NUM = B.ACTION_SEQ_NUM AND A.ORDER_ID = B.ORDER_ID WHERE A.ORDER_ID = ? ORDER BY ADDED_DATE DESC"; - Commented for IN051106
				String strsql1="SELECT DISTINCT A.ACTION_SEQ_NUM,AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') PRACTITIONER_NAME,SM_CONVERT_DATETIME_2T(A.ADDED_DATE,?) ADDED_DATE, A.ORDER_AMEND_REASON FROM OR_ORDER_AMEND_REASON A INNER JOIN "+tempTable+" B ON A.ACTION_SEQ_NUM = B.ACTION_SEQ_NUM AND A.ORDER_ID = B.ORDER_ID WHERE A.ORDER_ID = ? ORDER BY ADDED_DATE DESC"; // modified for IN051106
			try
			{
				conn 	= ConnectionManager.getConnection(request);
				pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				pstmt.setString(1,localeName);
				pstmt.setString(2,localeName);
				pstmt.setString(3,order_id);
				rs		= pstmt.executeQuery();
				int i=0;
				int j=1;
				while(rs.next())
				{
					if(i==0){
						action_seq_num = ((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM"));
						i++;
					}
					String amendRson=rs.getString("ORDER_AMEND_REASON")==null?"":rs.getString("ORDER_AMEND_REASON");					
						
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM")) ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(lineId ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM")) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(((rs.getString("ADDED_DATE")==null)?"":rs.getString("ADDED_DATE")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(((rs.getString("PRACTITIONER_NAME")==null)?"":rs.getString("PRACTITIONER_NAME")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
if((amendRson.length())>30){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(((rs.getString("ACTION_SEQ_NUM")==null)?"":rs.getString("ACTION_SEQ_NUM")) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(amendRson.substring(0,29)));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{ 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(amendRson ));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

					j++;
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}catch(Exception e){
				//out.println("Exception : "+e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();	
			}finally{
				if (conn != null) 
					ConnectionManager.returnConnection(conn,request);
			}
			
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(action_seq_num ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(lineId));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
