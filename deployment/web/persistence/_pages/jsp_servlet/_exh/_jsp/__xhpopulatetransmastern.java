package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import eXH.*;

public final class __xhpopulatetransmastern extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHPopulateTransMasterN.jsp", 1709122420646L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     \n\t\t\t<script> \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\tvar obj=parent.frames[1].document.forms[0].module_id;\n\t\t\tvar length = obj.length;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t//\t\talert(\"XHPopulateTransMasterN modl obj length : \"+length);\t\t\t       \n\t\t\tfor(i=0;i<length;i++)\t\t\t\t\t\t\t\t\t   \n\t\t\tobj.remove(1);\n\t\t\tvar obj1=parent.frames[1].document.forms[0].master_name;\t    \n\t\t\tvar length1 = obj1.length;\n\t\t\tfor(i=0;i<length1;i++)\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\tobj1.remove(1);\n\t\t\t</script>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t         opt=parent.frames[1].document.createElement(\"OPTION\");\n\n\t\t\t\t\t\n\t\t\t\t     opt.text=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t     opt.value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t parent.frames[1].document.forms[0].module_id.add(opt);\t \t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t  <script>\t  \n\t\t\t\t\t\tvar obj2=parent.frames[1].document.forms[0].module_id;\n\t\t\t\t\t\tfor(var i=0;i<obj2.options.length;i++)\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tif(obj2.options[i].value==\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj2.options[i].selected=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].module_id.selected=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t </script>\n\t\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script> \n\t\t\tvar obj=parent.frames[1].document.forms[0].master_name;\n\t\t\tvar obj1=parent.frames[1].document.forms[0].hidden_trans_table_id;\n\t\t\tvar length = obj.length;\n\t\t\tfor(i=0;i<length;i++){\n\t\t\t\tobj.remove(1);\n\t\t\t\tobj1.remove(1);\n\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t         opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt.text=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\n\t\t\t\t\t parent.frames[1].document.forms[0].master_name.add(opt);\n\n\t\t\t         opt1=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt1.text=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t     opt1.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\n\t\t\t\t\t parent.frames[1].document.forms[0].hidden_trans_table_id.add(opt1);\n\t\t\t\t\t \n\t\t\t\t \t\t\n                </script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t  <script>\t  \n\t\t\t\t\t\tvar obj3=parent.frames[1].document.forms[0].master_name;\n\t\t\t\t\t\tfor(var i=0;i<obj3.options.length;i++)\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tif(obj3.options[i].value==\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj3.options[i].selected=true;\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].module_id.selected=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 	
    request.setCharacterEncoding("UTF-8");
	Connection con            = null;
	Statement stmt            = null;
	PreparedStatement  pstmt  = null;													 
	ResultSet rs              = null;						  
    StringBuffer sql          = new StringBuffer();
	String code               = "";								   
	String desc               = "";
	String code1              = "";					 				 						   
	String desc1              = "";									   
	String trans_tbl_id		= "";		
	String fun_id=XHDBAdapter.checkNull(request.getParameter("fun_id")); 
	String module= request.getParameter("module")==null?"":request.getParameter("module"); 
//	String language           = request.getParameter("language")==null?"":request.getParameter("language");
	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String master_table_id	= request.getParameter("master_table_id")==null?"":request.getParameter("master_table_id");		     
//	System.out.println("module 28 :"+module);	 			    
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");	    
	String applicationid		= request.getParameter("application")==null?"":request.getParameter("application");
	System.out.println("XHPopulateTransMasterN.jsp applicationid :"+applicationid);	 			    

//		System.out.println("ModuleFlag : "+ModuleFlag);
	try{
		   con = ConnectionManager.getConnection(request);		     

			if(ModuleFlag.equals("Y"))
		    {									   
             try
               {
				  sql.setLength(0);
	//			  sql.append("select   module_id, module_name  from  sm_module ");
	//			  sql.append("SELECT   module_id, module_name  FROM  sm_module WHERE module_id IN (SELECT DISTINCT SUBSTR(MASTER_TABLE_ID,1,2) FROM  xh_mapping ) ");
				   sql.append("SELECT   module_id, module_name  FROM  sm_module WHERE module_id IN (SELECT DISTINCT SUBSTR(MASTER_TABLE_ID,1,2) FROM  xh_mapping WHERE   SUBSTR(MASTER_TABLE_ID,1,2) NOT IN ('XX') )  UNION   SELECT SUBSTR(MASTER_TABLE_ID,1,2),table_desc EXECUTION_NATURE FROM  xh_mapping WHERE   MASTER_TABLE_ID = 'XX' ");
				  sql.append(" order by module_name ");
				  pstmt = con.prepareStatement(sql.toString());						 
				  rs = pstmt.executeQuery();
			
            _bw.write(_wl_block4Bytes, _wl_block4);
	
					while (rs.next())
					{	 										    
						 code1 = rs.getString("module_id");	
						 if(code1==null) code1="";
				 
						 desc1 = rs.getString("module_name");
						 if(desc1==null) desc1="";
				 	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(desc1));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block7Bytes, _wl_block7);
	}
				  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(module));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(module));
            _bw.write(_wl_block10Bytes, _wl_block10);

						 if(fun_id.equals("SWITCHENTITY"))
   {
			  master_code=module;
			  sql.setLength(0);	
			if(master_code.equals("CA"))
			{						  
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') ");

				sql.append("order by table_desc");
			}else if(master_code.equals("SM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') ");

				sql.append("order by table_desc");
			}else{
	//			System.out.println("XHPopulateTransMasterN Modls Othr thn CA/SM  ");
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' ");

				sql.append("order by table_desc");			  
			}																					   
			stmt= con.createStatement();
				System.out.println("XHPopulateTransMasterN.jsp sql 122 : "+sql.toString());
			rs = stmt.executeQuery(sql.toString()) ;
            _bw.write(_wl_block11Bytes, _wl_block11);
	
					while (rs.next())
					{			
						 code = rs.getString("master_table_id");	
						 if(code==null) code="";
				 
						 desc = rs.getString("table_desc");
						 if(desc==null) desc="";

 						 trans_tbl_id = rs.getString(3);	
//						 System.out.println("trans_tbl_id : "+trans_tbl_id);

				 	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trans_tbl_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
	}
													 
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();


				sql.setLength(0);


   }									   
					 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(master_table_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(module));
            _bw.write(_wl_block10Bytes, _wl_block10);
											   
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
		     }catch(Exception e) { out.println("Main : "+e.toString());}			   
			} // end of ModuleFlag Y

           else {
			   
			if(master_code.equals("XX")){
				sql.setLength(0);	
	//			sql.append("SELECT  a.element_name, a.element_id element_id  FROM xh_element_crossref_lang_vw a, xh_appl_element b  WHERE a.element_id = b.element_id  AND b.application_id = '"+applicationid+"'  AND a.table_ID IS NOT NULL  AND b.in_use_yn = 'Y'   AND crossref_type = 'S'  AND a.in_use_yn = 'Y'  AND a.LANGUAGE_ID='"+locale+"'  ORDER BY 1 ";
				sql.append("SELECT  a.element_id element_id, a.element_name,'' DUMMY  FROM xh_element_crossref_lang_vw a, xh_appl_element b  WHERE a.element_id = b.element_id  AND b.application_id = '"+applicationid+"'   AND b.in_use_yn = 'Y'   AND a.in_use_yn = 'Y'  AND a.LANGUAGE_ID='en'  ORDER BY 1 ");
		   } // end of XX - NON Table

		   else{			   
//			   System.out.println("ModuleFlag!= Y");
				sql.setLength(0);				
					if(master_code.equals("CA"))
					{						  
						sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') ");

						sql.append("order by table_desc");
					}else if(master_code.equals("SM"))
					{
						sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') ");

						sql.append("order by table_desc");
					}else{
			//			System.out.println("XHPopulateTransMasterN Modls Othr thn CA/SM  ");
						sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' ");

						sql.append("order by table_desc");			  
					}
		   } // end of else
			stmt= con.createStatement();
				System.out.println("XHPopulateTransMasterN.jsp sql 122 : "+sql.toString());
			rs = stmt.executeQuery(sql.toString()) ;
            _bw.write(_wl_block11Bytes, _wl_block11);
	
					while (rs.next())
					{			
//						 code = rs.getString("master_table_id");	
						 code = rs.getString(1);	
						 if(code==null) code="";

//						 desc = rs.getString("table_desc");				 
						 desc = rs.getString(2);
						 if(desc==null) desc="";

 						 trans_tbl_id = rs.getString(3);	
//						 System.out.println("trans_tbl_id : "+trans_tbl_id);

				 	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trans_tbl_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
	}
													 
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();


				sql.setLength(0);

		   } // end of ModuleFlag 'N'
		   
		   
		}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		try{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}catch(Exception e) {}
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	

            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
