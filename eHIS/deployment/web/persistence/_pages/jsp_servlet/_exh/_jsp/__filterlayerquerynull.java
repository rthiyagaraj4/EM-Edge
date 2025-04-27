package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.util.regex.Pattern;
import java.lang.*;

public final class __filterlayerquerynull extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterLayerqueryNull.jsp", 1742466874976L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"JavaScript\" src=\'../../eCommon/js/common.js\'> </Script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n<script src=\'../../eXH/js/FilterLayerReference.js\' language=\'javascript\'></script>\n<script src=\'../../eXH/js/FilterLayerReferenceApplication.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script Language=\"JavaScript\" >\nfunction hide()\n{\n\tparent.frames[3].location.href=\'../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code=\'+document.forms[0].Filter_group_desc_id.value;\n}\n\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n  \n</HEAD>\n<BODY  leftmargin=0 topmargin=0  onMouseDown=\"CodeArrest()\"  onKeyDown =\'lockKey()\' onload=\'hide()\'>\n<form name=\"FilterSearchForm\" id=\"FilterSearchForm\" target=\'messageFrame\' >\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<input type=hidden name=count_fields id=count_fields value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n<input type=hidden name=actualmode id=actualmode value=\'I\'>\n<input type=hidden name=Filter_group_desc_id id=Filter_group_desc_id value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=hidden name=element_field id=element_field value=\'\'>\n\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle="IeStyle.css";
String filter_group = request.getParameter("Filter_group_code");
//System.out.println("filter_group35"+filter_group);

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

int levelcount=0;
ResultSet resultset = null;
PreparedStatement pstmt = null ;
Statement stment=null;
Connection conn = null;
ResultSet rset = null;
int j=1;
String replacestr=" ";
String reSecond = new String("'"+replacestr+"'");
int ach;
int ch;
try
{
if(conn==null) conn = ConnectionManager.getConnection();
}
 catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilterLayerqueryNull.jsp :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
 {
 stment= conn.createStatement();
 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+filter_group+"'");
 resultset.next();
 levelcount = resultset.getInt("rowcount") ;

 j=1 ;
int typeflag=0;
int subtypeflag=0;
resultset.close() ;
stment.close();
 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME,A.FACILITY_ID  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+filter_group+"' ORDER BY B.LEVEL_NUMBER";

 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
 while(rset.next())
 {
int level_number=Integer.parseInt(rset.getString(1).toString().trim());

String sql1=rset.getString(2);	
PreparedStatement pstmt1 = null ;
ResultSet resultset1 = null;
try{

String facility1= new String("'"+rset.getString(8).toString().trim()+"'");
sql1=rset.getString(3).toString().trim();
if(sql1.indexOf(":FACILITY")!=-1)
	{

        sql1=sql1.replaceAll(":FACILITY",facility1);
	}
	else
	{
        sql1=sql1;
	}

for(ch=1;ch<=(level_number*2);ch++)
{
	String str=":"+ch;
   sql1=sql1.replaceAll(str,reSecond);
}

//System.out.println("1st Column combo :"+sql1);

pstmt1 = conn.prepareStatement(sql1);
 resultset1 = pstmt1.executeQuery();
 while(resultset1.next())
	 {

	 }
if(pstmt1!=null )
 pstmt1.close() ;
 resultset1.close() ;
}
catch(Exception e)
	 {
	typeflag=1;
	 }
 
            _bw.write(_wl_block1Bytes, _wl_block1);

	try{

	
String sql2="";
PreparedStatement pstmt2 = null ;
ResultSet resultset2 = null;
//Regex = Pattern.compile("\\|",Pattern.MULTILINE);

String facility= new String("'"+rset.getString(8).toString().trim()+"'");

//System.out.println("reSecond :"+reSecond);
sql2=rset.getString(3).toString().trim();
/*if(rset.getString(3).indexOf(":1")!=-1)
	{ 
	
sql2=rset.getString(3).replaceAll(":1",reSecond);

//replacestr
//rset.getString(3);
	} 
	else
	{
		sql2=rset.getString(3);
	}*/
	for (ach=1;ach<=(level_number*2);ach++)
{
	String str=":"+ach;
sql2=sql2.replaceAll(str,reSecond);
}

if(rset.getString(3).indexOf(":FACILITY")!=-1)
	{

        sql2=sql2.replaceAll(":FACILITY",facility);
	}
	else
	{
        sql2=sql2;
	}
//System.out.println("2st Column combo :"+sql2);
pstmt2 = conn.prepareStatement(sql2);
 resultset2 = pstmt2.executeQuery();
 while(resultset2.next())
	 {
 

}
if(pstmt2!=null )
 pstmt2.close() ;
 resultset2.close() ;

            _bw.write(_wl_block1Bytes, _wl_block1);

/*String sql3="";
PreparedStatement pstmt3= null ;
ResultSet resultset3 = null;
sql3=rset.getString(4);	

System.out.println("sql3"+sql3);
pstmt3 = conn.prepareStatement(sql3);
 resultset3 = pstmt3.executeQuery();
 while(resultset3.next())
	 {
 

}
if(pstmt3!=null )
 pstmt3.close() ;
 resultset3.close() ;*/
 //out.println("<script>parent.frames[3].location.href='../../eXH/jsp/FilteringandschedulingApplicationLevel.jsp?Filter_group_code="+filter_group+"';</script>");
//out.println("<script>parent.frames[4].location.href='../../eXH/jsp/FilteringandschedulingApplicationSearch1.jsp?Filter_group_code="+filter_group+"';</script>");
out.println("<script>parent.frames[4].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code="+filter_group+"';</script>");


}catch(Exception exp)
      {
      subtypeflag=1;
//out.println("<script>parent.frames[3].location.href='../../eXH/jsp/FilteringandschedulingApplicationLevel.jsp?Filter_group_code="+filter_group+"';</script>");
out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html'</script>");
		// exp.printStackTrace(System.err);
		
      }
finally
	 {


 }

	 
	 }


if(pstmt!=null)
pstmt.close();
if(rset!=null)
rset.close() ;

  if(subtypeflag==1 || typeflag==1)
		 {

out.println("<script>alert('Query must be properly set it ...');</script>");
		 }

	}
catch(Exception exp)
      {
		
//out.println("<script>alert(getMessage('XH1046','XH'));</script>");
		 System.out.println("Error in calling getconnection method of FilterLayerqueryNull.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

finally
	{


		ConnectionManager.returnConnection(conn);
	}
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(j));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(filter_group));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
