package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __catabintermediatevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CATabIntermediateValidate.jsp", 1732512299572L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String sql="";
	int resultCount = 0;
	String action = request.getParameter("ACTION") == null ? "": request.getParameter("ACTION");
	obj=new XMLStringParser();
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	
	if("VALIDATE_PAT_ENC".equals(action)){
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		
		try{
			con				=	ConnectionManager.getConnection(request);
			sql="select count(*) COUNT from PR_ENCOUNTER where patient_id = ? and encounter_id = ?";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()){
				resultCount=Integer.parseInt(rs.getString("COUNT"));	
			}
			if(resultCount<=0){
				out.println("validationCheck('N','','')");
			}else{
				out.println("validationCheck('Y','"+patient_id+"','"+encounter_id+"')");
			}
		}
		catch(Exception e){
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
					
	}else if("POPULATEENCOUNTERFOROP".equals(action)){
		String patient_id	= request.getParameter( "patient_id" ) ;
		ArrayList encounterDetails = new ArrayList();
		try{
			con = ConnectionManager.getConnection(request) ;
			pstmt		= con.prepareStatement("SELECT   encounter_id FROM pr_encounter WHERE patient_id = ? ORDER BY VISIT_ADM_DATE_TIME DESC");
			pstmt.setString(1, patient_id);
			
			rs			= pstmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					encounterDetails.add(rs.getString("ENCOUNTER_ID"));
				}
			}
			out.println("clearData('document.formClaimFormsCriteria.encounterId');") ;
			if(encounterDetails.size() <= 0){
				out.println("addEncounter('',' ---Select---','document.formClaimFormsCriteria.encounterId');");
			}
			else {	
				for(int i=0; i<encounterDetails.size(); i++) {			
					out.println("addEncounterDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.formClaimFormsCriteria.encounterId','');") ;			
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		
			finally
		{
			if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con);
		}
		
	}
	else{
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String p_report_id = (String)hash.get("p_report_id");
			
			Clob clobData = null;
			try{
				con				=	ConnectionManager.getConnection(request);
				//sql="select DATA from logo_chk where SNO='"+id+"'";
				sql="select SIGNATURE from CA_PAT_INSU_SIGNATURE where patient_id = ? and encounter_id = ? and report_id = ? ";
				pstmt			=	con.prepareStatement(sql);
				pstmt.setString(1, patient_id);
				pstmt.setString(2, encounter_id);
				pstmt.setString(3, p_report_id);
				rs				=	pstmt.executeQuery();
				if(rs.next()) {
					clobData = rs.getClob("SIGNATURE");
					String wholeClob = clobData.getSubString(1, (int) clobData.length());
						System.out.println("SIGNATURE:"+wholeClob);
						out.println("testView('"+wholeClob+"')");
				}else{
					/* out.println("errorMsg()"); */
				}
			
			}
			
			catch(Exception e){
				//out.println("Exception@1: "+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
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
