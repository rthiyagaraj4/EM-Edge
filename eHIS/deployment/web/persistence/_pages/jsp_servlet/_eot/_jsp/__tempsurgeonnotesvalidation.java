package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tempsurgeonnotesvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/TempSurgeonNotesValidation.jsp", 1709117294000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
		String facility_id      = (String) session.getAttribute("facility_id");
		String oper_num =	checkForNull(request.getParameter("oper_num")) ;
		String doc_level =	checkForNull(request.getParameter("doc_level")) ;
		String Speciality_code_val =	checkForNull(request.getParameter("Speciality_code_val")) ;
		request.setCharacterEncoding("UTF-8");
		String accession_num = checkForNull(request.getParameter("contr_mod_accession_num"));
		//String SQL ="SELECT AUTHORIZED_BY_ID FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? ";
		String SQL ="SELECT AUTHORIZED_BY_ID FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM = ? and Event_Status <> '9'";//added by Sanjay for Surgeon Notes against IN34391
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		String authorize_by_id="";
		String result = "OK";
		String speciality_code = "";
		String contr_mod_accession_num="";
		
		try{
			con = ConnectionManager.getConnection(request);
			//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
		/*	if(func_mode.equalsIgnoreCase("getPractRoleType")){
			String sql			= "";		
			String role_type_id	= "";
			String pract_id	= "";
			String compareString= "";
			sql="SELECT B.ROLE_TYPE, A.PRACTITIONER_ID FROM OT_POST_OPER_PERSONNEL A, OT_ROLES_LANG_VW B, AM_SPECIALITY C,AM_PRACTITIONER D, AM_POSITION E WHERE B.LANGUAGE_ID = ? AND OPERATING_FACILITY_ID =? AND OPER_NUM	= ? AND A.SPECIALITY_CODE = C.SPECIALITY_CODE (+) AND A.ROLE_ID = B.ROLE_ID AND A.PRACTITIONER_ID = D.PRACTITIONER_ID AND  D.POSITION_CODE    = E.POSITION_CODE(+)";
			
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,facility_id);
			pstmt1.setString(3,oper_num);
			rst1 = pstmt1.executeQuery();
			while(rst1.next()){
				role_type_id=rst1.getString(1);
				pract_id=rst1.getString(2);
				compareString=compareString+"@@"+role_type_id+"||"+pract_id;
			
			}
			out.println(compareString);
		}else{*/
if(("IS").equals(doc_level))
{
String	spec_code_chk_last=  Speciality_code_val.substring(Speciality_code_val.length()-1);
if(spec_code_chk_last.equals("*"))
{
		StringTokenizer token=new StringTokenizer(Speciality_code_val,"*");
			while(token.hasMoreTokens())
			{
			 speciality_code=token.nextToken();
			 contr_mod_accession_num = facility_id+oper_num+speciality_code+"30";
						pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			}
}else
	{
	        spec_code_chk_last=  Speciality_code_val;
			contr_mod_accession_num = facility_id+oper_num+spec_code_chk_last+"30";
			

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
}

/*
		StringTokenizer token=new StringTokenizer(Speciality_code_val,",");
			while(token.hasMoreTokens())
			{
			 speciality_code=token.nextToken();
			 contr_mod_accession_num = facility_id+oper_num+speciality_code+"30";
						pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			}*/
			}
          /* if(("IS").equals(doc_level))
			{
		    pstmt1 = con.prepareStatement(sql_speciality);
			pstmt1.setString(1,facility_id);
			pstmt1.setString(2,oper_num);
			rst1 = pstmt1.executeQuery();
			while(rst1.next()){	
			speciality_code	= checkForNull(rst1.getString(1));//speciality_code
			contr_mod_accession_num = facility_id+oper_num+speciality_code+"30";

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,contr_mod_accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			}
			}*/
			else if(("AS").equals(doc_level))
			{
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,accession_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				authorize_by_id = rst.getString(1);
				if(rst.wasNull())
				{
					result = "Surgeon Notes is not Authorized!, Please Authorize the Notes.";
				}
			}else	
				{
				result = "Surgeon Notes is not entered!, Please enter the Notes.";
				}
			
			}
			out.println(result);
		}catch(Exception e){
			System.err.println("Err Msg in TempSugeonNotesValidation.jsp"+e.getMessage());
		} finally{
			try{
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				if(rst1!=null)rst1.close();
				if(pstmt1!=null)pstmt1.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
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
