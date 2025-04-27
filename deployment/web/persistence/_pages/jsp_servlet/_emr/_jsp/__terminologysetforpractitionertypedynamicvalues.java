package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __terminologysetforpractitionertypedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologySetForPractitionerTypeDynamicValues.jsp", 1709119122020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'>\n\t<form name=Dynamic_form>\n\t\t<input type=hidden name=E value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\n\t\t<input type=hidden name=R value=\'\'>\n\t\t<input type=hidden name=S value=\'\'>\n\t\t<input type=hidden name=X value=\'\'>\n\t\t<input type=hidden name=Y value=\'\'>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	TerminologySetForPractitionerTypeDyanamicValues.jsp
*	Purpose 			:	to Store the selected practitioner type into the RecordSet
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	Statement stmt_practType=null;
	ResultSet rs_practType=null;
	String clearAll="";
	String term_set_id="";
	try{
		term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
		clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");
		//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
         String pract_name=request.getParameter("pract_type_text");
         String search_criteria=request.getParameter("search_criteria");
        if(pract_name == null || pract_name.equals("undefined")) pract_name="";
        if(search_criteria == null || search_criteria.equals("undefined")) search_criteria="";
		RecordSet	TerminologySetForPractitionerType	=	null;
		RecordSet	TerminologySetForPractitionerType1	=	null;
		TerminologySetForPractitionerType	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologySetForPractitionerType");
		TerminologySetForPractitionerType1	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologySetForPractitionerType1");

		if(clearAll.equals("clearAll")){
		   StringBuffer sql= new StringBuffer();
         sql.append("select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from mr_term_set_for_pract_type a, am_pract_type b where a.term_set_id ='"+term_set_id+"' and b.pract_type = a.pract_type");
		   if(pract_name!=null){ 
				 if(search_criteria.equals("S")){
					sql.append(" and upper(b.DESC_USERDEF) not like upper('"+pract_name+"%') ");
				}else if(search_criteria.equals("C")){
					sql.append(" and upper(b.DESC_USERDEF) not like upper('%"+pract_name+"%') ");
				}else if(search_criteria.equals("E")){
					sql.append(" and upper(b.DESC_USERDEF) not like upper('%"+pract_name+"') ");
				 }
             }
             sql.append(" order by 2 ");
			 
			TerminologySetForPractitionerType.clearAll();
			TerminologySetForPractitionerType1.clearAll();
            con = ConnectionManager.getConnection(request);
           stmt_practType=con.createStatement();
           rs_practType=stmt_practType.executeQuery(sql.toString());
            sql.setLength(0);
           while(rs_practType.next())
            {
          TerminologySetForPractitionerType.putObject(rs_practType.getString(1));
		  }
         } else if(clearAll.equals("notCleared")){
		 
		 StringBuffer sql= new StringBuffer("select pract_type, desc_userdef pract_type_desc, 'I' db_action from am_pract_type where pract_type not in (select pract_type from mr_term_set_for_pract_type where term_set_id = '"+term_set_id+"') and eff_status='E' ");
     if(pract_name!=null){
	if(clearAll.equals("notCleared")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(DESC_USERDEF) like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(DESC_USERDEF) like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(DESC_USERDEF) like upper('%"+pract_name+"') ");
		}
	}else if(clearAll.equals("clearAll")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(DESC_USERDEF) not like upper('"+pract_name+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(DESC_USERDEF) not like upper('%"+pract_name+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(DESC_USERDEF) not like upper('%"+pract_name+"') ");
		}
	}
}

    sql.append(" union all ");
    sql.append("select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from mr_term_set_for_pract_type a, am_pract_type b where a.term_set_id ='"+term_set_id+"' and b.pract_type = a.pract_type");
	
    sql.append(" order by 2 ");	 
	con = ConnectionManager.getConnection(request);
	//String sql_practType="select pract_type, desc_userdef pract_type_desc, 'I' db_action from am_pract_type where pract_type not in (select pract_type from mr_term_set_for_pract_type where term_set_id = '"+term_set_id+"') and eff_status='E' union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from mr_term_set_for_pract_type a, am_pract_type b where a.term_set_id ='"+term_set_id+"' and b.pract_type = a.pract_type order by 2";
         
	stmt_practType=con.createStatement();
    rs_practType=stmt_practType.executeQuery(sql.toString());
    sql.setLength(0);
	//end SKR-SCF-0739 [IN:036606] 
	while(rs_practType.next()){
	if(!(TerminologySetForPractitionerType.containsObject(rs_practType.getString(1))))
		TerminologySetForPractitionerType.putObject(rs_practType.getString(1));
	}
}

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block4Bytes, _wl_block4);

	}
	catch(Exception e){/* out.print(e); */e.printStackTrace();}
		finally{

		if(rs_practType!=null)
			  rs_practType.close();
		if(stmt_practType!=null)
			  stmt_practType.close();
		ConnectionManager.returnConnection(con,request);

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
