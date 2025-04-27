package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;

public final class __terminologycodeforcasetypedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/TerminologyCodeForCaseTypeDynamicValues.jsp", 1724911931687L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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
            webbeans.eCommon.RecordSet TermCodeForCaseType= null;synchronized(session){
                TermCodeForCaseType=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TermCodeForCaseType",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TermCodeForCaseType==null){
                    TermCodeForCaseType=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TermCodeForCaseType",TermCodeForCaseType,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

 request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
Connection con	= null;
PreparedStatement pstmt	= null;
ResultSet rs = null;
String select =	request.getParameter("select");
ArrayList TabList =	null;
ResultSet resultSet=null;
String[] record=null;
ArrayList nature_Data	= new ArrayList();	
String case_type_code=request.getParameter("case_type_code");
con = ConnectionManager.getConnection(request);
String term_set_id		=	"";
String type	=	"";
String flag	=	"";
String sql_associated="";
String alphalink="";	
String sql_nature="";
String code	=	"";
String mandatory_yn="";
String actual_yn="";
String potential_yn="";
String wellness_yn="";
String select_val="";
String temp_code="";
try
	{
		if(select.equals("lookup"))
		{
	 sql_nature="Select case_type_nature from cp_case_type where case_type_code = ?";
		pstmt = con.prepareStatement( sql_nature);
		pstmt.setString(1,case_type_code);
				resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[1];				
			record[0] = resultSet.getString("case_type_nature")==null ? "": resultSet.getString("case_type_nature");
			if(record[0].equals("I"))
				record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.lllness.label","cp_labels");
			else
				record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");;
			nature_Data.add(record) ;
		}
	  if(resultSet!=null) resultSet.close();
	  if(pstmt!=null) pstmt.close();
		for( int i=0 ; i< nature_Data.size() ; i++ ) {
			record = (String[])nature_Data.get(i);
			out.println( "assignNature(\"" + record[0] + "\");") ;	
			
		}
		}
	else if(select.equals("SELECTALL"))
		{

		 term_set_id		=	request.getParameter("term_set_id");
		 type	=	request.getParameter("type");
		 flag	=	request.getParameter("flag");
		 sql_associated="";
		 alphalink								=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		alphalink	= alphalink.trim();
	if(alphalink.equals("Associated"))
		{			
			if(type.equals("PR"))
			{
			 sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_p_"+term_set_id+"_vw b,mr_term_code c WHERE a.case_type_code = '"+case_type_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) ORDER BY 3";
			}
			else
			{			
			sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_d_"+term_set_id+"_vw b, mr_term_code c WHERE a.case_type_code = '"+case_type_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) ORDER BY 3";
			}
		}
		else
		{			
			if(type.equals("PR"))
			{			
			 sql_associated="select term_set_id, term_code, short_desc, actual_yn, potential_yn, wellness_yn, 'N' mandatory_yn,'I' db_action from mr_p_"+term_set_id+"_vw where term_set_id = '"+term_set_id+"' and code_level = (select defn_levels from mr_term_set where term_set_id = '"+term_set_id+"') and (('"+alphalink+"' is not null and upper(short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(short_desc,1,1) not between 'A' and 'Z' )) and (term_set_id, term_code) not in (select term_set_id,term_code from cp_term_code_for_case_type where case_type_code = '"+case_type_code+"') union all select a.term_set_id, a.term_code, b.short_desc , b.actual_yn, b.potential_yn, b.wellness_yn,a.mandatory_yn,'U' db_action from cp_term_code_for_case_type a, mr_p_"+term_set_id+"_vw b,mr_term_code c where a.case_type_code = '"+case_type_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and  (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and upper(b.short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(b.short_desc,1,1) not between 'A' and 'Z'))  order by 3 ";  
			}
			else
			{			
				sql_associated="select term_set_id, term_code, short_desc, actual_yn, potential_yn, wellness_yn, 'N' mandatory_yn,'I' db_action from mr_d_"+term_set_id+"_vw where term_set_id = '"+term_set_id+"' and (('"+alphalink+"' is not null and upper(short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(short_desc,1,1) not between 'A' and 'Z' )) and (term_set_id, term_code) not in (select term_set_id,term_code from cp_term_code_for_case_type where case_type_code = '"+case_type_code+"') union all select a.term_set_id, a.term_code, b.short_desc , b.actual_yn, b.potential_yn, b.wellness_yn,a.mandatory_yn,'U' db_action from cp_term_code_for_case_type a, mr_d_"+term_set_id+"_vw b,mr_term_code c where a.case_type_code = '"+case_type_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.term_set_id = b.term_set_id and c.term_code = b.term_code and (( '"+type+"' = 'PR' and c.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and c.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and upper(b.short_desc) like '"+alphalink+"%') or ('"+alphalink+"' is null and substr(b.short_desc,1,1) not between 'A' and 'Z'))  order by 3 "; 
			}
	
		}
	pstmt	=		con.prepareStatement(sql_associated);
	rs	= pstmt.executeQuery();
	if(rs!=null)
	{
		while(rs.next()){
			 code	=	rs.getString("term_code");
			 mandatory_yn=rs.getString("mandatory_yn");
			 actual_yn=rs.getString("actual_yn");
			 potential_yn=rs.getString("potential_yn");
			 wellness_yn=rs.getString("wellness_yn");
			 select_val="N";
			if(actual_yn.equals("Y")){
				if(potential_yn.equals("Y"))
					select_val="B";
				else
					select_val="A";
			}
			else
				if(potential_yn.equals("Y"))
					select_val="P";
			if(wellness_yn.equals("Y"))
				select_val="W";
		int index=-1;

		if(TermCodeForCaseType != null){
			for(int i=0;i<TermCodeForCaseType.getSize();i++){
				TabList=new ArrayList();
				TabList=(ArrayList)TermCodeForCaseType.getObject(i);
				 temp_code=(String)TabList.get(0);
				if(temp_code.equals(code)){
					index=i;
					break;
				}
			}
			if(index != -1){
				if(!flag.equals("1"))
					TermCodeForCaseType.removeObject(index);
			}
			else
				if(flag.equals("1")){
					TabList = new ArrayList();
					TabList.add(code);
					TabList.add(mandatory_yn);
					TabList.add(actual_yn);
					TabList.add(potential_yn);
					TabList.add(wellness_yn);
					TabList.add(select_val);
					TermCodeForCaseType.putObject(TabList);
			}
		}	
	  }
    }
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
  }
	
}
catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
  finally
  {
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);

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
