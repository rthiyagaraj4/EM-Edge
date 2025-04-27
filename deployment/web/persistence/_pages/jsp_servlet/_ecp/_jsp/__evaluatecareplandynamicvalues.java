package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __evaluatecareplandynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanDynamicValues.jsp", 1740026228836L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\t\t\t<script>\n\t\t\t\tvar select = parent.eval_cp_criteria.document.eval_cp_crit.eval_ind;\n\t\t\t\tvar length\t=\tMath.abs(select.length); \n\t\t\t\tfor (i=0;i<length;i++)\n\t\t\t\t\tselect.remove(0);\n\t\t\t\tvar option\t=\tparent.eval_cp_criteria.document.createElement(\"OPTION\");\n\t\t\t\toption.text = \"---Select---\";\n\t\t\t\toption.value = \"\";\t\n\t\t\t\tselect.add(option);\n\t\t\t</script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script>\n\t\t\t\tvar option\t= parent.eval_cp_criteria.document.createElement(\"OPTION\");\n\t\t\t\toption.value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\toption.text\t= \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\tselect.add(option);\n\t\t\t</script>\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	 //This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String facilty_id = (String)session.getAttribute("facility_id");
Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;
PreparedStatement pstmt=null;
ResultSet rset = null;
//
PreparedStatement stmt_outcome_msr = null;
ResultSet  rs_outcome_msr = null;
Statement stmt_outcome_msr_id = null;
ResultSet  rs_outcome_msr_id = null;
//
String[] record	= null;
String selected_locn_type = request.getParameter("selected_locn_type");
String type = request.getParameter("type");
String term_set_id=	request.getParameter("diagnosis_set")==null?"":request.getParameter("diagnosis_set");
String patient_id=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
try
{
	con = ConnectionManager.getConnection(request);
	if(type.equals("selected_locn_type"))
	{
		String sql_ind = "Select care_locn_type_ind from am_care_locn_type where locn_type = ?";
		stmt = con.prepareStatement(sql_ind);
		stmt.setString(1,selected_locn_type);
		rs = stmt.executeQuery();
		String indicator = "";
		if(rs!=null)
		{
			if(rs.next())
			{
				indicator = rs.getString("care_locn_type_ind");
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		String sql_2ndlst = "Select clinic_code, long_desc from op_clinic where facility_id = ? and eff_Status = 'E' and care_locn_type_ind = ? order by long_desc";
		stmt = con.prepareStatement(sql_2ndlst);
		stmt.setString(1,facilty_id);
		stmt.setString(2,indicator);
		rs = stmt.executeQuery();
		String clinic_code = "";
		String long_desc = "";
		if(rs!=null)
		{

            _bw.write(_wl_block1Bytes, _wl_block1);

			while(rs.next())
			{
				clinic_code = rs.getString("clinic_code");
				long_desc = rs.getString("long_desc");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);

			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
	}
	if(type.equals("eval_diag"))
	{
		    String sql_diagnosis		= "";
	
			sql_diagnosis="select distinct b.term_set_id term_set_id,b.term_code term_code,c.short_desc diag_desc from cp_pat_care_plan a, cp_pat_care_plan_term_code b, mr_term_code c where a.patient_id = ? and a.current_facility_id = ? and current_status = 'O' and a.care_plan_start_date <= sysdate  and b.md_care_plan_id = a.md_care_plan_id and b.care_plan_id = a.care_plan_id  and b.status = 'O' and c.term_set_id = nvl(?,c.term_set_id) and c.term_set_id = b.term_set_id and c.term_code = b.term_code order by diag_desc";
			pstmt = con.prepareStatement(sql_diagnosis);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facilty_id);
			pstmt.setString(3,term_set_id);
			rset = pstmt.executeQuery();
     	   	ArrayList Term_List		= new ArrayList();	
			if(rset != null)
    		{
				while (rset.next()) 
				{
					record = new String[2];				
					record[0]=rset.getString("term_code");
					record[1] = rset.getString("diag_desc");
					Term_List.add(record);
				}
			}
		//to list diagnosis
			for( int i=0 ; i< Term_List.size() ; i++ ) 
			{
				record = (String[])Term_List.get(i);
				out.println("addDiagnosis(\"" + record[0] + "\",\"" + record[1] + "\") ; " );
			}
	}

	if(type.equals("eval_msr")){
		String id=request.getParameter("id");
		String outcomecode=request.getParameter("code");
		String outcomecount=request.getParameter("count");
		String outcome_pct=request.getParameter("pct");
		String objtype=request.getParameter("objtype");
		//System.err.println(""+);
		String eval_msr_sql="SELECT CUT_OFF_SCORE FROM CP_OUTCOME_MSR WHERE OUTCOME_CODE=? AND OUTCOME_MSR_ID=?";
		String score="";
		stmt_outcome_msr = con.prepareStatement(eval_msr_sql);
		stmt_outcome_msr.setString(1,outcomecode);
		stmt_outcome_msr.setString(2,id);
		rs_outcome_msr=stmt_outcome_msr.executeQuery();
		if(rs_outcome_msr!=null){
			rs_outcome_msr.next();
			score=rs_outcome_msr.getString("CUT_OFF_SCORE");
			out.println("setScore(\""+score + "\",\""+outcomecount+"\",\""+outcome_pct+"\",\""+id+"\",\""+objtype+"\") ; " );
		}
		if(rs_outcome_msr!=null)
					rs_outcome_msr.close();
		if(stmt_outcome_msr!=null)
					stmt_outcome_msr.close();
	}
	if(type.equals("eval_msr_ID")){
		
		String outcomecode=request.getParameter("outcomecode");
		String outcomecount=request.getParameter("outcomecount");
		int score=Integer.parseInt(request.getParameter("score"));
		String objtype=request.getParameter("objtype");
		
		//System.err.println("objtype "+objtype);
		ArrayList msridlist=new ArrayList();
		int msrscore=0;
		String finalid="";

		//String eval_msr_id_sql="SELECT OUTCOME_MSR_ID,CUT_OFF_SCORE FROM CP_OUTCOME_MSR WHERE OUTCOME_CODE='"+outcomecode+"' ORDER BY CUT_OFF_SCORE DESC";//common-icn-0180
		String eval_msr_id_sql="SELECT OUTCOME_MSR_ID,CUT_OFF_SCORE FROM CP_OUTCOME_MSR WHERE OUTCOME_CODE= ? ORDER BY CUT_OFF_SCORE DESC";//common-icn-0180
		
		//stmt_outcome_msr_id	=	con.createStatement();//common-icn-0180
		pstmt=con.prepareStatement(eval_msr_id_sql);//common-icn-0180
		pstmt.setString(1, outcomecode);//common-icn-0180
		
		//rs_outcome_msr_id	=	stmt_outcome_msr_id.executeQuery(eval_msr_id_sql);//common-icn-0180
		rs_outcome_msr_id	=	pstmt.executeQuery();//common-icn-0180

		if(rs_outcome_msr_id!=null){
			while(rs_outcome_msr_id.next()){
				msridlist.add(rs_outcome_msr_id.getString("OUTCOME_MSR_ID"));
				msridlist.add(rs_outcome_msr_id.getString("CUT_OFF_SCORE"));
			}
			
		}
		
		for(int i=0;i<msridlist.size();i=i+2){
				msrscore=Integer.parseInt((String)msridlist.get(i+1));
				if(msrscore<=score){
					finalid=(String)msridlist.get(i);
					break;
				}
			}
		//System.err.println("score "+score);
		//System.err.println("msrscore "+msrscore);
		//System.err.println("finalid "+finalid);

		out.println("setMsrId(\""+finalid + "\",\""+outcomecount+"\",\""+objtype+"\") ; " );
		if(rs_outcome_msr_id!=null)
					rs_outcome_msr_id.close();
		if(stmt_outcome_msr_id!=null)
					stmt_outcome_msr_id.close();
	}
	if(type.equals("eval_termCode_msr"))
	{
		String termsetId=request.getParameter("termsetId");
		String termCode=request.getParameter("termCode");
		String diag_count=request.getParameter("diag_count");
		String diag_pct=request.getParameter("diag_pct");
		String id=request.getParameter("id");
		String eval_termcode_msr_sql="SELECT CUT_OFF_SCORE FROM CP_TERM_CODE_MSR WHERE TERM_SET_ID=? AND TERM_CODE=? AND TERM_CODE_MSR_ID=?";
		String score="";
		stmt_outcome_msr = con.prepareStatement(eval_termcode_msr_sql);
		stmt_outcome_msr.setString(1,termsetId);
		stmt_outcome_msr.setString(2,termCode);
		stmt_outcome_msr.setString(3,id);
		rs_outcome_msr=stmt_outcome_msr.executeQuery();
		if(rs_outcome_msr!=null){
			rs_outcome_msr.next();
			score=rs_outcome_msr.getString("CUT_OFF_SCORE");
			out.println("setTermCodeScore(\""+termsetId+"\",\""+termCode+"\",\""+score + "\",\""+diag_count+"\",\""+diag_pct+"\",\""+id+"\") ; " );
		}
		if(rs_outcome_msr!=null)
					rs_outcome_msr.close();
		if(stmt_outcome_msr!=null)
					stmt_outcome_msr.close();
		//System.err.println("Score in validate"+score);
	}
	if(type.equals("eval_termcode_msr_ID")){
		
		String termSetid=request.getParameter("termSetid");
		String termcode =request.getParameter("termcode");
		//System.err.println("termcode "+termcode);
		String termcodecount=request.getParameter("termcodecount");
		int score=Integer.parseInt(request.getParameter("score"));
		
		ArrayList msridlist=new ArrayList();
		int msrscore=0;
		String finalid="";

		//String eval_msr_id_sql="SELECT TERM_CODE_MSR_ID,CUT_OFF_SCORE FROM CP_TERM_CODE_MSR WHERE TERM_SET_ID='"+termSetid+"' and TERM_CODE='"+termcode+"' ORDER BY CUT_OFF_SCORE DESC";//common-icn-0180
		String eval_msr_id_sql="SELECT TERM_CODE_MSR_ID,CUT_OFF_SCORE FROM CP_TERM_CODE_MSR WHERE TERM_SET_ID=? and TERM_CODE=? ORDER BY CUT_OFF_SCORE DESC";//common-icn-0180

		//		System.err.println("eval_msr_id_sql "+eval_msr_id_sql);
		//stmt_outcome_msr_id	=	con.createStatement();//common-icn-0180
		pstmt=con.prepareStatement(eval_msr_id_sql);//common-icn-0180
		pstmt.setString(1, termSetid);//common-icn-0180
		pstmt.setString(2, termcode);//common-icn-0180
		
		//rs_outcome_msr_id	=	stmt_outcome_msr_id.executeQuery(eval_msr_id_sql);//common-icn-0180
		rs_outcome_msr_id	=	pstmt.executeQuery();//common-icn-0180

		if(rs_outcome_msr_id!=null){
			while(rs_outcome_msr_id.next()){
				msridlist.add(rs_outcome_msr_id.getString("TERM_CODE_MSR_ID"));
				msridlist.add(rs_outcome_msr_id.getString("CUT_OFF_SCORE"));
			}
			
		}
	//System.err.println("msridlist  "+msridlist);
		for(int i=0;i<msridlist.size();i=i+2){
				msrscore=Integer.parseInt((String)msridlist.get(i+1));
				//System.err.println("score "+score);
				//System.err.println("msrscore<=score  "+(msrscore<=score));
				if(msrscore<=score){
				//	System.err.println("inside if");
					finalid=(String)msridlist.get(i);
					break;
				}
			}
	/*	System.err.println("score "+score);
		System.err.println("msrscore "+msrscore);
		System.err.println("finalid "+finalid);*/
		if(rs_outcome_msr_id!=null)
					rs_outcome_msr_id.close();
		if(stmt_outcome_msr_id!=null)
					stmt_outcome_msr_id.close();
		out.println("settermCodeMsrId(\""+finalid + "\",\""+termcodecount+"\") ; " );
	}

}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
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
