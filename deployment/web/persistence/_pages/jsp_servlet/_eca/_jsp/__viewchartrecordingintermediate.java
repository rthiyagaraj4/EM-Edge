package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewchartrecordingintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewChartRecordingIntermediate.jsp", 1709115257015L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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

/*
-----------------------------------------------------------------------
Date		Edit History	Name			Description
-----------------------------------------------------------------------
15/03/2012					Ramesh G           created
---------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
---------------------------------------------------------------------------------------------
23/11/2017	IN061897		Raja S			23/11/2017		Ramesh G		ML-MMOH-CRF-0549				  
---------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	try 
	{
		String modeId 		=  request.getParameter("Mode")==null ? "" : request.getParameter("Mode");		
		String practitionerId 		=  request.getParameter("PractiotionerID")==null ? "" : request.getParameter("PractiotionerID");
		String facility_id 		=  request.getParameter("facility_id")==null ? "" : request.getParameter("facility_id");//IN061897
		String clientIpAddress 		=  request.getParameter("clientIpAddress")==null ? "" : request.getParameter("clientIpAddress");//IN061897
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;
		Statement stm = null;
		String result="";
		String def_chartId="";
		if("GetChartId".equals(modeId)){
			try{
				con = ConnectionManager.getConnection();
				//psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = '"+practitionerId+"'");	//common-icn-0180
				psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = ?");	//common-icn-0180
				psmt.setString(1, practitionerId);//common-icn-0180
				rset = psmt.executeQuery();
				if(rset.next()){						
					result=rset.getString("CHART_ID")==null ? "" : rset.getString("CHART_ID");
				}
			}catch(Exception e){					
				System.out.println(e);
				result="Error";
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{
				if(psmt!=null)psmt.close();
				if(rset!=null) rset.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);					
			}			
		}else if("SaveChartId".equals(modeId)){
			def_chartId 		=  request.getParameter("Chart_Id")==null ? "" : request.getParameter("Chart_Id");
			try{
				con = ConnectionManager.getConnection();
				//psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = '"+practitionerId+"'");	//common-icn-0180
				psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = ?");	//common-icn-0180
				psmt.setString(1, practitionerId);//common-icn-0180
				rset = psmt.executeQuery();
				if(rset.next()){
					//stm = con.createStatement();//common-icn-0180
					//stm.execute("UPDATE  CA_VIEWCHART_DEF_CONFIG SET CHART_ID='"+def_chartId+"' WHERE PRACTITIONER_ID='"+practitionerId+"'");//common-icn-0180
					psmt = con.prepareStatement("UPDATE  CA_VIEWCHART_DEF_CONFIG SET CHART_ID=? WHERE PRACTITIONER_ID=?");//common-icn-0180
					psmt.setString(1, def_chartId);//common-icn-0180
					psmt.setString(2, practitionerId);//common-icn-0180
					rset = psmt.executeQuery();//common-icn-0180
				}else{
					//stm = con.createStatement();//common-icn-0180
					//stm.execute("INSERT INTO CA_VIEWCHART_DEF_CONFIG (PRACTITIONER_ID,CHART_ID) VALUES ('"+practitionerId+"','"+def_chartId+"')");//common-icn-0180
					psmt = con.prepareStatement("INSERT INTO CA_VIEWCHART_DEF_CONFIG (PRACTITIONER_ID,CHART_ID) VALUES (?,?)");//common-icn-0180
					psmt.setString(1, practitionerId);//common-icn-0180
					psmt.setString(2, def_chartId);//common-icn-0180
					rset = psmt.executeQuery();//common-icn-0180
				}
				result = "Success";
				con.commit();
			}catch(Exception e){					
				System.out.println(e);
				result=e.getMessage();
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{ 
				if(stm!=null)stm.close();
				if(psmt!=null)psmt.close();
				if(rset!=null) rset.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);					
			}			

		}else if("UpdateChartId".equals(modeId)){
			def_chartId 		=  request.getParameter("Chart_Id")==null ? "" : request.getParameter("Chart_Id");
			try{
				con = ConnectionManager.getConnection();				
				//stm = con.createStatement();//common-icn-0180
				//stm.execute("DELETE FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID='"+practitionerId+"'");	//common-icn-0180		
				psmt = con.prepareStatement("DELETE FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID=?");	//common-icn-0180		
				//stm.execute("UPDATE  CA_VIEWCHART_DEF_CONFIG SET CHART_ID='"+def_chartId+"' WHERE PRACTITIONER_ID='"+practitionerId+"'");
				psmt.setString(1, practitionerId);//common-icn-0180
					
				rset = psmt.executeQuery();//common-icn-0180
				result = "Success";
				con.commit();
			}catch(Exception e){					
				System.out.println(e);
				result=e.getMessage();
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{
				if(stm!=null)stm.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);	
				if(psmt!=null)psmt.close();//common-icn-0180
				if(rset!=null) rset.close();//common-icn-0180
			}		
//IN061897 changes starts
		}else if("SetChartToDefault".equals(modeId)){
			def_chartId 		=  request.getParameter("Chart_Id")==null ? "" : request.getParameter("Chart_Id");
				eCA.CAViewChartBean bean = new eCA.CAViewChartBean();
				result = bean.setPracDefaultChart(def_chartId,practitionerId,facility_id,clientIpAddress);
		}
//IN061897 changes ends
		out.println(result);											

	}
	catch (Exception e) 
	{
		//out.println("alert(\"" + e + "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
