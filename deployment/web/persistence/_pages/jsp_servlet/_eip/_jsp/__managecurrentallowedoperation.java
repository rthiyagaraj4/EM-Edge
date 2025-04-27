package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.*;

public final class __managecurrentallowedoperation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ManageCurrentAllowedOperation.jsp", 1709117795400L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n    <head>\n\t \t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n       <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n       <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n   \t\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n       <script language=\'javascript\' src=\'../../eIP/js/IPManageCurrent.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n  \n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n</head>\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n       ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\n\t  var tab_dat =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n      tab_dat +=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n      tab_dat +=\"</table>\";\n     parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n     parent.frames[2].ManageCurrentInPatientsQueryResultForm.document.getElementById(\"t\").innerHTML= tab_dat;\n\t\n\t  </script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
  
		request.setCharacterEncoding("UTF-8");
        Connection con=null;
        try{       
		con=ConnectionManager.getConnection(request);
         String P_USER_ID           = (String) session.getValue("login_user");
         String  P_FACILITY_ID=(String)session.getValue("facility_id");
        String P_ENCOUNTER_ID =request.getParameter("encounter_id");
		String P_PATIENT_ID=request.getParameter("patient_id");
	    String P_NURSING_UNIT  =request.getParameter("nursing_unit_code");
		if(P_NURSING_UNIT==null) P_NURSING_UNIT="";
		String P_BED_NO  =request.getParameter("bed_no");
		if(P_BED_NO==null) P_BED_NO="";
		String P_OPER_STN_ID  =request.getParameter("oper_stn_id");
		//String locale = (String) session.getValue("LOCALE");
		String res_function_name = "";
		StringBuffer tablevalues=new StringBuffer("<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>");
		StringBuffer columnvalues=new StringBuffer();
		StringBuffer columnvalues1=new StringBuffer();
    
            _bw.write(_wl_block7Bytes, _wl_block7);

            try
            {
                PreparedStatement pstmt=null;
				ResultSet rs=null;


			String sql_new="SELECT IP_GET_BED_OPERN('"+P_FACILITY_ID+"','"+P_ENCOUNTER_ID+"','"+P_PATIENT_ID+"','"+P_OPER_STN_ID+"','"+P_USER_ID+"','"+P_NURSING_UNIT+"','"+P_BED_NO+"')  res_function_name FROM DUAL";

		
			
               pstmt=con.prepareStatement(sql_new);
               rs=pstmt.executeQuery();
               
	           
			  if (rs!=null)
				{
					 while (rs.next())
					{
					  res_function_name=rs.getString("res_function_name")==null?"":rs.getString("res_function_name");
					}
					
				}
			if (pstmt != null) pstmt.close();
			if(rs != null) rs.close();


String function_name="";
String Function_st="";

if(!res_function_name.equals(""))
	{
		  StringTokenizer strToken_fnID = new StringTokenizer(res_function_name,"||");

		   while(strToken_fnID.hasMoreTokens())
	 {

           Function_st		= strToken_fnID.nextToken(); 
		   								


    if(!Function_st.equals("*"))
	 {		
          //String sql2="SELECT FUNCTION_NAME FROM SM_FUNCTION_LANG WHERE FUNCTION_ID = '"+Function_st+"' AND MODULE_ID = 'IP' AND LANGUAGE_ID = '"+locale+"'";

          String sql2="select sm_get_desc.sm_function('IP','"+Function_st+"','en',1) from dual";
			

			pstmt = con.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
          

			  if (rs!=null)
		      {
					  while (rs.next())
					  {
						  function_name = rs.getString(1);
					  }
				}
	
	
			if (pstmt != null) pstmt.close();
			if(rs != null) rs.close();

//	 columnvalues.append("<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);' ><a>"+function_name+"</a></td></tr>");

			 columnvalues.append("<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);' ><a href=javascript:CallFunction('"+P_FACILITY_ID+"','"+P_ENCOUNTER_ID+"','"+P_PATIENT_ID+"','"+P_OPER_STN_ID+"','"+P_USER_ID+"','"+P_NURSING_UNIT+"','"+P_BED_NO+"','"+Function_st+"');>"+function_name+"</a></td></tr>") ; 

		  
            _bw.write(_wl_block8Bytes, _wl_block8);
 
		   }     
	   columnvalues1.append("<input type='hidden' name='Function_st' id='Function_st' value='"+Function_st+"'>");
	  
		   }
		  
//strToken_fnID=null;
//Function_st="";
//res_function_name="";
//function_name="";
//P_USER_ID="";
//P_FACILITY_ID="";
//P_ENCOUNTER_ID="";
//P_PATIENT_ID="";
//P_OPER_STN_ID="";
//P_NURSING_UNIT="";
//P_BED_NO="";


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tablevalues));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(columnvalues));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(columnvalues1));
            _bw.write(_wl_block11Bytes, _wl_block11);


	         }
	         }
            catch(Exception e){
				e.printStackTrace();
			}
       }catch(Exception e) {}
finally{	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
