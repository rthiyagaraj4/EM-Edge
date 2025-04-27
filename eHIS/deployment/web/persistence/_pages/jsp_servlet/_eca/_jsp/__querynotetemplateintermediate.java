package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __querynotetemplateintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QueryNoteTemplateIntermediate.jsp", 1719311419622L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	
	StringTokenizer rowTok = null;
	StringTokenizer rowTok1 = null;
//	StringTokenizer colTok = null;
	String arrVal ="";
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
	String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
	
	if(operation_mode.equals("addToBean"))
	{
		
		eCA.PatientBannerGroupLine queryTemplateBean = null;

//		String hashKey ="";
//		String hashValue ="";
		
		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		String final_string = request.getParameter("final_string")==null?"":request.getParameter("final_string");
		String rem_string = request.getParameter("rem_string")==null?"":request.getParameter("rem_string");

		try{
		rowTok = new StringTokenizer(final_string,"`");

		while(rowTok.hasMoreTokens())
		{
			arrVal = (String) rowTok.nextToken();

			if(!queryTemplateBean.returnList1().contains(arrVal))
			{
				queryTemplateBean.addRecordstoLine1(arrVal);
			}
			
		}
		rowTok1 = new StringTokenizer(rem_string,"`");

		while(rowTok1.hasMoreTokens())
		{
			arrVal = (String) rowTok1.nextToken();

			if((queryTemplateBean.returnList1().contains(arrVal)))
			{
				queryTemplateBean.remRecordsFromLine1(arrVal);
			}
		}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}


		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);

	}
	else if(operation_mode.equals("loadToBean"))
	{
		
		eCA.PatientBannerGroupLine queryTemplateBean = null;

//		String hashKey ="";
//		String hashValue ="";
		String sec_hdg_code ="";
		String comp_id ="";
		String srl_no ="";
		String prompt_id ="";
		String result_type ="";
		int count=0;

		arrVal ="";
		
		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		String query_id = request.getParameter("query_id")==null?"":request.getParameter("query_id");
		String temp_det =" select SEC_HDG_CODE,COMP_ID,SRL_NO,PROMPT_ID,RESULT_TYPE from CA_TEMP_QRY_DTL  where QUERY_REF =? ";

		try
		{

			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(temp_det);
			stmt.setString(1,query_id);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				sec_hdg_code = rs.getString("SEC_HDG_CODE")==null?"":rs.getString("SEC_HDG_CODE");	
				comp_id = rs.getString("COMP_ID")==null?"":rs.getString("COMP_ID");	
				srl_no = rs.getString("SRL_NO")==null?"":rs.getString("SRL_NO");	
				prompt_id = rs.getString("PROMPT_ID")==null?"":rs.getString("PROMPT_ID");	
				result_type = rs.getString("RESULT_TYPE")==null?"":rs.getString("RESULT_TYPE");	
	
				arrVal = sec_hdg_code+"~"+comp_id+"~"+srl_no+"~"+prompt_id+"~"+result_type;	

				if(!queryTemplateBean.returnList1().contains(arrVal))
				{
					queryTemplateBean.addRecordstoLine1(arrVal);
				}
				count++;
			
			}
		
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}

		out.println("parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value='"+count+"'");

		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);


	}
	else if(operation_mode.equals("remove"))
	{
		
		arrVal ="";

		String mode = "";

		eCA.PatientBannerGroupLine queryTemplateBean = null;
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		arrVal = request.getParameter("arrVal")==null?"":request.getParameter("arrVal");

		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		if(mode.equals("Add"))
		{
			
			if(!queryTemplateBean.returnList1().contains(arrVal))
				{
					queryTemplateBean.addRecordstoLine1(arrVal);
				}
		}
		else if (mode.equals("Rem"))
		{
			if((queryTemplateBean.returnList1().contains(arrVal)))
			{
				queryTemplateBean.remRecordsFromLine1(arrVal);
			}

		}


		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);	

	}
	else if(operation_mode.equals("clearBean"))
	{
		
		
		eCA.PatientBannerGroupLine queryTemplateBean = null;
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		
		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		queryTemplateBean.clearBean();
				

		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);	

	}





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
