package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public final class __cpaccessrightsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/CPAccessRightsQueryCriteria.jsp", 1709116519576L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teCP\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tHema Malini B\n*\tCreated On\t\t:\t24 Jan 2005\n\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'stylesheet\' type=\'text/css\'href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
 
//This file is saved on 18/10/2005.
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 ecis.utils.CommonQueryPage querypage= new ecis.utils.CommonQueryPage();
StringBuffer strbuf;

Connection con=null;
PreparedStatement Practitioner_pstmt=null;
ResultSet Practitioner_rs=null;

try{
	con=ConnectionManager.getConnection(request);
	
  ArrayList Practitioner_Data		= new ArrayList() ;
  String[] record  = null;
  String Practitioner_sql="";

  

  Practitioner_sql="Select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";

  Practitioner_pstmt=con.prepareStatement(Practitioner_sql);
  Practitioner_rs= Practitioner_pstmt.executeQuery();
  	 	try{
		   if(Practitioner_rs!=null)
		     {
			 while(Practitioner_rs.next())
			  {
				 record=new String[2];
					record[0]= Practitioner_rs.getString("pract_type");
					record[1]=  Practitioner_rs.getString("desc_userdef");
					Practitioner_Data.add(record);
			  }
			 }
	 }catch(Exception exp){exp.toString();}
	ArrayList finalArray=new ArrayList();

	ArrayList firstItem=new ArrayList();
	firstItem.add("List"); //Type of item
	firstItem.add("Practitioner Type"); // label
	firstItem.add("pract_type"); //name
	
	String strList="%"+","+"-------------------All----------------------"+",";
	for( int k=0;k<Practitioner_Data.size();k++)
	{
		record=(String[])Practitioner_Data.get(k);
		strList=strList+ (String)record[0]+","+(String)record[1]+",";
	}
	firstItem.add(strList);  //Values to be passed
   	finalArray.add(firstItem);

    ArrayList secondItem=new ArrayList();
	secondItem.add("Text"); //Type of item
	secondItem.add("Practitioner Name"); // label
	secondItem.add("practitioner_name"); //name
	secondItem.add("30");  //size
    secondItem.add("30");   //Length
	finalArray.add(secondItem);

	ArrayList ThirdItem=new ArrayList();
	ThirdItem.add("Text"); //Type of item
	ThirdItem.add("Practitioner ID"); // label
	ThirdItem.add("practitioner_id"); //name
	ThirdItem.add("15");  //size
	ThirdItem.add("15");  //Length

   	finalArray.add(ThirdItem);

	
	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0]	= "Practitioner Type";
	orderByCols[1]	= "Practitioner Name";
	orderByCols[2]	= "Practitioner ID";
	
	orderByColVals[0] = "c.pract_type";
	orderByColVals[1] = "practitioner_name";
	orderByColVals[2] = "b.practitioner_id";


   strbuf = querypage.getQueryPage(con,finalArray,"AccessRights","../jsp/CPAccessRightsQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

   out.println(strbuf.toString());

}catch(Exception e)
{//out.println(e.toString());//common-icn-0181
e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(Practitioner_rs != null) Practitioner_rs.close();
	if(Practitioner_pstmt != null) Practitioner_pstmt.close();
	ConnectionManager.returnConnection(con,request);
}



            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
