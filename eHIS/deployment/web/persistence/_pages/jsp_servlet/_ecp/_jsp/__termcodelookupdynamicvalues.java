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

public final class __termcodelookupdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/TermCodeLookupDynamicValues.jsp", 1724916065001L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet BuildLibraryTermCode= null;synchronized(session){
                BuildLibraryTermCode=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BuildLibraryTermCode",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BuildLibraryTermCode==null){
                    BuildLibraryTermCode=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BuildLibraryTermCode",BuildLibraryTermCode,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet BuildLibrary= null;synchronized(session){
                BuildLibrary=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BuildLibrary",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BuildLibrary==null){
                    BuildLibrary=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BuildLibrary",BuildLibrary,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
Connection con						=		null;
PreparedStatement pstmt				=		null;
ResultSet rs						=		null;
String validate						=		request.getParameter("validate");
HashMap TermCodeData				=		new HashMap();
ArrayList TabList					=		null;
ArrayList TermCode					=		null;


ArrayList sessionList1				=		(ArrayList)BuildLibrary.getRecordSetHandle();
if(sessionList1.size()>0)
{
	TermCode=(ArrayList)BuildLibrary.getObject(0);
}

ArrayList sessionList				=		(ArrayList)BuildLibraryTermCode.getRecordSetHandle();
if(sessionList.size()>0)
{
	TermCodeData=(HashMap)BuildLibraryTermCode.getObject(0);
}

if(validate.equals("LEVEL")){
	String termSetId	=	request.getParameter("termSetid");
	String sqlData		=	"Select nature_appl_yn, proc_spec_yn, diag_spec_yn,DEFN_LEVELS,LEVEL_1_DESC,LEVEL_2_DESC,LEVEL_3_DESC,LEVEL_4_DESC,LEVEL_5_DESC,LEVEL_6_DESC,LEVEL_7_DESC,LEVEL_8_DESC,LEVEL_9_DESC,LEVEL_10_DESC from mr_term_set where term_set_id = ?";
	String levelData		=		"";
	try{
		con						=		ConnectionManager.getConnection(request);
		pstmt					=		con.prepareStatement(sqlData);
		pstmt.setString(1,termSetId);
		rs							=		pstmt.executeQuery();
		while (rs != null && rs.next()) {
			levelData			=		rs.getString("nature_appl_yn")+"||";
			levelData			=		levelData+rs.getString("proc_spec_yn")+"||";
			levelData			=		levelData+rs.getString("diag_spec_yn")+"||";
			levelData			=		levelData+rs.getString("DEFN_LEVELS")+"||";
			levelData			=		levelData+rs.getString("LEVEL_1_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_2_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_3_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_4_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_5_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_6_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_7_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_8_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_9_DESC")+"||";
			levelData			=		levelData+rs.getString("LEVEL_10_DESC")+"||";
		}
	}catch(Exception e){
		//out.print(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
    	  ConnectionManager.returnConnection(con,request);
	}
		out.println( "assignLevels(\"" + levelData + "\");") ;	

}else if(validate.equals("CODEUPDATE")){

	String code			=		request.getParameter("code");
	String flag				=		request.getParameter("flag");
	String desc				=		request.getParameter("desc");
	String termSet		=		request.getParameter("termSet");
	String tableName	=request.getParameter("tableName");
	//System.err.println("tableName"+tableName);

	String tempTermSet	=	"";
	String tempTermCode	=	"";
	
	boolean found		=	false;

	for(int j=0;j<TermCode.size();j=j+7){
			 tempTermSet	= (String)TermCode.get(j);
			 tempTermCode	= (String)TermCode.get(j+1);

			if(tempTermSet.equals(termSet) && tempTermCode.equals(code)){
				int index=TermCode.indexOf(code);
				if(flag.equals("1")){
					TermCode.set(index+2,"Y");
				} else {
					TermCode.set(index+2,"N");
				}
				found	=	true;
				break;
			}
	}
	
	if(!found) {			
			TermCode.add(termSet);
			TermCode.add(code);
			ArrayList Goal=new ArrayList();
			TermCode.add(Goal);
			TermCode.add("Y");
			TermCode.add("I");	
			TermCode.add(desc);
			TermCode.add(tableName);
						
	}


	if(TermCodeData.containsKey(termSet))
	{
		TabList=(ArrayList)TermCodeData.get(termSet);
	}else
	{
		TabList=new ArrayList();
	}
	
	if(TabList.contains(code)){
		int index=TabList.indexOf(code);
		if(flag.equals("1"))
			TabList.set(index+2,"Y");
		else
			TabList.set(index+2,"N");
		
	}else{
		TabList.add(code);
		TabList.add(desc);
		TabList.add("Y");
		TabList.add("I");

	}
	
	
	TermCodeData.put(termSet,TabList);
	
	

	}
BuildLibraryTermCode.setObject(0,TermCodeData);
//BuildLibrary.setObject(0,TermCode);


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
