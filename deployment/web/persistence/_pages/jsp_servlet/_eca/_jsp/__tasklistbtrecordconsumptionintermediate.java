package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.sql.Types;
import webbeans.eCommon.*;

public final class __tasklistbtrecordconsumptionintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TaskListBTRecordConsumptionIntermediate.jsp", 1734579746142L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

		request.setCharacterEncoding("UTF-8");	
		java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
        String locale = (String) property.getProperty("LOCALE");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String patient_id =hash.get("patient_id")==null?"":(String) hash.get("patient_id");
		String order_facility_id =hash.get("order_facility_id")==null?"":(String) hash.get("order_facility_id");
		String specimen_no =hash.get("specimen_no")==null?"":(String) hash.get("specimen_no");
		String product_code =hash.get("product_code")==null?"":(String) hash.get("product_code");		
		String unit_no =hash.get("unit_no")==null?"":(String) hash.get("unit_no");		
		String product_desc =hash.get("product_desc")==null?"":(String) hash.get("product_desc");		
		String blood_group =hash.get("blood_group")==null?"":(String) hash.get("blood_group");	
		String rhesus_code =hash.get("rhesus_code")==null?"":(String) hash.get("rhesus_code");
		String strStat="",strErr="",strTotal="";
		
		
		Connection con = null; 
		String strxMatchResult	=	"N";
		PreparedStatement pst	=	null;
		PreparedStatement pstmt	=	null;
		ResultSet rsParam		=	null,resultSet = null;
		String query;
		String message_txt="";
		int flag=0;
		if (locale.equals("US")==true || locale.equals("en")==true || locale.equals("GB")==true || locale.length()==0)
		{
		  flag=0;
	      query =	"SELECT message_id||'-'||NVL(message_text,message_text_sysdef) MSG_TXT	FROM SM_MESSAGE WHERE UPPER(message_ref) = UPPER(?)";
		}
	   else
		{
		  flag=1;
	      query =	"SELECT 	M.message_id||'-'||NVL(D.message_text,D.message_text_sysdef) MSG_TXT FROM 	SM_MESSAGE	M, SM_MESSAGE_DESC D WHERE 	UPPER(D.message_ref) = UPPER(?) 	AND D.language_id = ? AND UPPER(M.message_ref) = UPPER(D.message_ref)";
		}

		try 
		{						
			try
			{
				con=ConnectionManager.getConnection();
     			pst		=	con.prepareStatement("SELECT nvl(XMATCH_RESULT_BEFORE_TRANS_YN,'N') From BT_Param");
				rsParam =	pst.executeQuery();

				if(rsParam != null && rsParam.next())
				{
					strxMatchResult	=	rsParam.getString(1);
				}

			}
			catch(Exception e)
            {
	          e.printStackTrace();	
            }
			finally
			{
				if(rsParam != null) rsParam.close();
				if(pst != null) pst.close();
			}
		
			CallableStatement callableStatement=null;		
				
			if(strxMatchResult.equals("Y") )
			{
			    callableStatement=con.prepareCall("{ call BT_TRANSFUSE_COMMIT.BT_TRANSFUSE_UNIT_CHECK(?,?,?,?,?,?,?)}");

				callableStatement.setString(1,order_facility_id);
				callableStatement.setString(2,patient_id);
				callableStatement.setString(3,specimen_no);
				callableStatement.setString(4,unit_no);
				callableStatement.setString(5,product_code);

				callableStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(7,java.sql.Types.VARCHAR);				

				callableStatement.execute();
	
		        strStat = callableStatement.getString(6);
			    strErr  = callableStatement.getString(7);

			    if(strStat==null||strStat.equalsIgnoreCase("null"))		  strStat=" ";
				
			    if(strErr==null||strErr.equalsIgnoreCase("null"))		  strErr=" ";
									
		        callableStatement.close();
				pstmt=con.prepareStatement(query);

	            pstmt.setString(1, strErr);
	            if(flag == 1) 	pstmt.setString(2,locale);

	            resultSet	= pstmt.executeQuery();
				while(resultSet!= null && resultSet.next())
				{	
				  message_txt=resultSet.getString( "MSG_TXT" );						
				}

	            message_txt =(message_txt==null?"":message_txt);
	            
				if(strStat!=null ) 
				{
				   out.println( "validateBT(\""+strStat+"\",\"" +message_txt+" \") ; " ) ;
				}
			}
			/* Added by Uma on 11/30/2010 for IN025273*/
			else
			{
				 out.println( "validateBT(\""+strStat+"\",\"" +message_txt+" \") ; " ) ;
			}
			/*Ends here*/
		}
		catch(Exception e)
        {
	        e.printStackTrace();	
        }
		finally
		{
			try
			{
				if(resultSet!=null) resultSet.close();
				if(pstmt !=null) pstmt.close();
				ConnectionManager.returnConnection(con, request);
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
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
