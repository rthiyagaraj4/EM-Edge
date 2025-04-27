package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;

public final class __manageworkscheduletransferdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleTransferDynamicValues.jsp", 1709117440447L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>\n   parent.ManageWorkScheduleTransfer_frames.document.ManageWorkScheduleTransfer.transfer.value = \"\";\n\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<script>\n\tparent.ManageWorkScheduleTransfer_frames.document.ManageWorkScheduleTransfer.p_requirement_id.value = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
  
String shift_val = request.getParameter("shift_val")==null?"":request.getParameter("shift_val");
String p_schedule_date = request.getParameter("p_schedule_date")==null?"":request.getParameter("p_schedule_date");
String p_facility_id = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
String p_position_code = request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
String transfer = request.getParameter("transfer")==null?"":request.getParameter("transfer");
String p_requirement_id = "";
String shift_code = "";
out.println("shift_val in manageworkscheduletransferdyanamicvalues.jsp 18  {"+shift_val+"}");
try
{
	con = ConnectionManager.getConnection(request);
	HashMap sft_hm = new HashMap();
	StringBuffer sft_sb = new StringBuffer();
	String sql_v = "SELECT a.requirement_id requirement_id,b.shift_code shift_code FROM RS_WORKPLACE_REQUIREMENT a,RS_WORKPLACE_REQUIREMENT_DTL b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_type = 'V' AND TO_DATE(?,'dd/mm/yyyy') BETWEEN a.requirement_date_fm 	   	    AND a.requirement_date_to  AND b.facility_id = a.facility_id AND b.workplace_code = a.workplace_code AND b.requirement_id = a.requirement_id  AND b.position_code = ? AND ";
	StringTokenizer stk = new StringTokenizer(shift_val,",");
	String sft_stk = "";
	sql_v	+=	"b.shift_code IN(";
	boolean first_time	=	true;
	while(stk.hasMoreTokens())	{				
		sft_stk = stk.nextToken();
		sft_hm.put(sft_stk,"N");
		if(!first_time)
			sql_v		+= ",";
		if(first_time){
			sql_v		+= "'"+(sft_stk)+"'";
			first_time	=	false;
		} 
		else{
			sql_v		+= "'"+(sft_stk)+"'";
		}
	}
	sql_v	+=	")";
	pstmt = con.prepareStatement(sql_v);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,transfer);
	pstmt.setString(3,p_schedule_date);
	pstmt.setString(4,p_position_code);
	rs = pstmt.executeQuery();
	if(rs!=null){
		while(rs.next()){
			p_requirement_id = rs.getString("requirement_id");
			shift_code = rs.getString("shift_code");
			if(sft_hm.containsKey(shift_code))
			{
				sft_hm.put(shift_code,"Y");
			}
		}
	}
	if(pstmt != null) pstmt.close();
	if(rs != null)	rs.close();
	if(p_requirement_id.equals(""))
	{
		String sql_c = "SELECT a.requirement_id, b.shift_code shift_code FROM RS_WORKPLACE_REQUIREMENT a,RS_WORKPLACE_REQUIREMENT_DTL b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_type = 'C' AND a.requirement_date_fm IS NULL AND a.requirement_date_to IS NULL AND b.facility_id = a.facility_id AND b.workplace_code = a.workplace_code AND b.requirement_id = a.requirement_id AND b.position_code = ? AND ";
		stk = new StringTokenizer(shift_val,",");
		sql_c	+=	"b.shift_code IN(";
		first_time	=	true;
		while(stk.hasMoreTokens())	{				
			if(!first_time)
				sql_c		+= ",";
			if(first_time){
				sql_c		+= "'"+(stk.nextToken().trim())+"'";
				first_time	=	false;
			} 
			else{
				sql_c		+= "'"+(stk.nextToken().trim())+"'";
			}
		}
		sql_c	+=	")";
		pstmt = con.prepareStatement(sql_c);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,transfer);
		pstmt.setString(3,p_position_code);

		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				p_requirement_id = rs.getString("requirement_id");
				shift_code = rs.getString("shift_code");
				if(sft_hm.containsKey(shift_code)){
					sft_hm.put(shift_code,"Y");
				}
			}
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	String shift_ind = "";
	String sKey = "";
	Set stKeys = sft_hm.keySet(); 
	Iterator it = stKeys.iterator();
	int i = 0;
	while(it.hasNext())
	{
		sKey = (String)it.next();
		shift_ind = (String) sft_hm.get(sKey);
		if(shift_ind.equals("N")){
			if(i!=0){
				sft_sb.append(",");
			}
			sft_sb.append("'"+sKey+"'");
			i++;
		}
	}
	if(!sft_sb.toString().equals(""))
	{
		i = 0;
		String sql_desc = "select short_desc from am_shift where shift_code in("+sft_sb.toString()+")";
		StringBuffer short_desc = new StringBuffer();
		pstmt = con.prepareStatement(sql_desc);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				if(i!=0){
					short_desc.append(",");
				}
				short_desc.append(rs.getString("short_desc"));
				i++;
			}
			i = 0;
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		if(!short_desc.toString().equals("")){
			out.println("<script>alert('APP-RS0038 No requirment for "+(short_desc.toString())+" shifts')</script>");

            _bw.write(_wl_block6Bytes, _wl_block6);

		}
	}
	else
	{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_requirement_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
