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

public final class __termcodeevalmeasurevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/TermCodeEvalMeasureValidate.jsp", 1724911906746L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
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

/*
--------------------------------------------------------------------------------------------------------
Date			 Edit History      Name		Rev.Date	Rev.Name       Description
--------------------------------------------------------------------------------------------------------
?				100					?												created
8/1/2014	  LICN_1			Karthi			8/1/2014	Dinesh T			MMS Internal Issue.
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet TermCodeEvalMeasure= null;synchronized(session){
                TermCodeEvalMeasure=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TermCodeEvalMeasure",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TermCodeEvalMeasure==null){
                    TermCodeEvalMeasure=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TermCodeEvalMeasure",TermCodeEvalMeasure,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

 request.setCharacterEncoding("UTF-8");
Connection con						=		null;
PreparedStatement pstmt				=		null;
ResultSet rs						=		null;
String validate						=		request.getParameter("validate");
String termSet="";
String termCode="";
String id="";
String Desc="";
String score="";
String seq_no="";
int index=0;
int selectedRecords = 0; //  LICN_1 
ArrayList Tablist = null;
ArrayList sessionList				=		(ArrayList)TermCodeEvalMeasure.getRecordSetHandle();
if(sessionList.size()>0){
	Tablist=(ArrayList)TermCodeEvalMeasure.getObject(0);
}
//System.err.println("Tablist in validate "+Tablist);

try{
	if(validate.equals("LEVEL")){
		String termSetId	=	request.getParameter("termSetid");
		String sqlData		=	"Select nature_appl_yn, proc_spec_yn, diag_spec_yn from mr_term_set where term_set_id = ?";
		String levelData		=		"";
		con						=		ConnectionManager.getConnection(request);
		pstmt					=		con.prepareStatement(sqlData);
		pstmt.setString(1,termSetId);
		rs							=		pstmt.executeQuery();
		while (rs != null && rs.next()) {
			levelData			=		rs.getString("nature_appl_yn")+"||";
			levelData			=		levelData+rs.getString("diag_spec_yn")+"||";
			levelData			=		levelData+rs.getString("proc_spec_yn")+"||";
			}
		rs.close();
		pstmt.close();
			out.println( "assignLevels(\"" + levelData + "\");") ;	
	}
	else if(validate.equals("INSERTVALUE"))
	{
		 termSet=request.getParameter("termSet");
		 termCode=request.getParameter("termCode");
		 id=request.getParameter("id");
		 Desc=request.getParameter("Desc");
		 score=request.getParameter("score");
		 seq_no=request.getParameter("seq_no");
		 index=0;
		//System.err.println("id in validate "+id);
		if(Tablist.contains(id)){
			index=Tablist.indexOf(id);
			Tablist.set(index,id);
			Tablist.set(index+1,Desc);
			Tablist.set(index+2,score);
			Tablist.set(index+3,seq_no);
		}else{
			Tablist.add(id);
			Tablist.add(Desc);
			Tablist.add(score);
			Tablist.add(seq_no);
			Tablist.add("I");  //flag to specify the action
		}
		//System.err.println("Tablist in validate "+Tablist);
	}
	else if(validate.equals("DELETEVALUE"))
	{
		termSet=request.getParameter("termSet");
		termCode=request.getParameter("termCode");
		id=request.getParameter("id");
		//System.err.println("id in validate "+id);
		Desc=request.getParameter("Desc");
		score=request.getParameter("score");
		seq_no=request.getParameter("seq_no");
		index=0;
		String flag="";
		if(Tablist.contains(id))
		{
			index=Tablist.indexOf(id);
			flag=(String)Tablist.get(index+4);
			if(flag.equals("U"))
			{
				Tablist.set(index+4,"D");
			}
			else
			{
				Tablist.remove(index+4);
				Tablist.remove(index+3);
				Tablist.remove(index+2);
				Tablist.remove(index+1);
				Tablist.remove(index);
			}

		}
	}
	else if(validate.equals("COUNTRECORD")) { // added for LICN_1 - START
		
		if(Tablist != null) {
				if(!Tablist.isEmpty()) {
					if(Tablist.contains("I") || Tablist.contains("U")) {
						selectedRecords = Tablist.size();  //  LICN_1 
						out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
					}
					else {
						selectedRecords = 0;  //  LICN_1 
						out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
					}
				}
			}
		} // END
}catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
        e.printStackTrace();//COMMON-ICN-0181
}finally{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
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
