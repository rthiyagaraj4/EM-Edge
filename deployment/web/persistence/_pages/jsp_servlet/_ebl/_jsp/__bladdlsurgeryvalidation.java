package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.*;
import webbeans.op.CurrencyFormat;
import eOR.*;
import eOR.Common.*;

public final class __bladdlsurgeryvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAddlSurgeryValidation.jsp", 1709114389151L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\t\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n\t<head>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!--\t<body onLoad=\'chk1()\'>-->\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\n\t\t<body onLoad=\'chk()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<form>\t\n\n\t\t<input type=\"hidden\" name=\"str_add_blng_serv_code\" id=\"str_add_blng_serv_code\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"> \n\t\t<input type=\"hidden\" name=\"order_cat_code\" id=\"order_cat_code\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"> \n\t\t<input type=\"hidden\" name=\"ord_catlog_count\" id=\"ord_catlog_count\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> \n\t\t<input type=\"hidden\" name=\"cat_i\" id=\"cat_i\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> \n\t\t<input type=\"hidden\" name=\"checked_val\" id=\"checked_val\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> \n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t<script>\n\t\t\t\tfunction chk()\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar a_str_add_srv = new Array();\n\t\t\t\t\tvar str_add_srv=document.forms[0].str_add_blng_serv_code.value;\n\t\t\t\t//\talert(str_add_srv);\n\t\t\t\t\ta_str_add_srv=str_add_srv.split(\"|\");\n\t\t\t\t\tvar ord_catlog_count = document.forms[0].ord_catlog_count.value;\n\t\t\t\t\tvar cat_i = document.forms[0].cat_i.value;\n\t\t\t\t\tvar checked_val = document.forms[0].checked_val.value;\n\t\t\t\t//\talert(\"checked_val :\"+checked_val);\n\t\t\t\t\tfor(i=0;i<ord_catlog_count;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tif(i==cat_i)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar order_serv_cnt = eval(\"parent.frames[1].document.forms[0].order_serv_cnt_\"+i);\n\t\t\t\t//\t\t\talert(\"order_serv_cnt :\"+order_serv_cnt.value);\n\t\t\t\t\t\t\tvar order_serv_cnt_tt = eval(order_serv_cnt.value)+1;\n\t\t\t\t\t\tfor(j=0;j<order_serv_cnt_tt;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tserv_code=eval(\"parent.frames[1].document.forms[0].blng_serv_code_\"+i+\"_\"+j);\n\n\t\t\t\t\t\t//\talert(\"22: \"+serv_code.value);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tfor(k=0;k<a_str_add_srv.length;k++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t//alert(\"22  11: \"+serv_code.value);\n\n\t\t\t\t\t\t\t\tif(a_str_add_srv[k]==serv_code.value)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t//alert(\"tr\");\n\t\t\t\t\t\t\t\t\tvar sel_val=eval(\"parent.frames[1].document.forms[0].selected_row_\"+i+\"_\"+j);\n\t\t\t\t\t\t\t\t\tif(checked_val==\"Y\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tsel_val.checked=true;\n\t\t\t\t\t\t\t\t\t\tsel_val.value=\"Y\";\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\tsel_val.checked=false;\n\t\t\t\t\t\t\t\t\tsel_val.value=\"N\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\tparent.frames[2].total_amt();\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\n\n\t\t</script>\n\n\t\t</form>\n\t\t</body>\n\t\t</html>\n\n";
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
	
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement pstmt = null ;	
	//Statement stmt = null; 
	ResultSet rst1=null,rst2=null;	
	CallableStatement call = null;
	String currdate="",add_blng_serv_code="",addl_serv_code="",order_cat_code="",str_add_blng_serv_code="",ord_catlog_count="",ord_i="",checked_val="";
	int tot_blng_class_code=0;
	String blng_class_code="",error_level="",sys_message_id="",error_text="",blng_class_code_orig="";
	//ArrayList a_dep_serv_code	= new ArrayList();

            _bw.write(_wl_block2Bytes, _wl_block2);

		try{
			con	=	ConnectionManager.getConnection(request);	
//			HttpSession httpSession = request.getSession(false);
//			Properties p = (Properties)httpSession.getValue("jdbc");
			String locale = (String)session.getAttribute("LOCALE");			
			if(locale==null || locale.equals("")) locale="en";		
			String str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			String	strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";

//			System.out.println("in validation");

			String p_patient_id = request.getParameter("p_patient_id");	
			if(p_patient_id==null) p_patient_id="";	
//			System.out.println("p_patient_id " +p_patient_id);

			
			String episode_type = request.getParameter("episode_type");	
			if(episode_type==null) episode_type="";	
		
			String episode_id = request.getParameter("episode_id");	
			if(episode_id==null) episode_id="";	

			String visit_id = request.getParameter("visit_id");	
			if(visit_id==null) visit_id="";	
		

			addl_serv_code = request.getParameter("blng_serv_code");	
			if(addl_serv_code==null) addl_serv_code="";					
			//System.out.println("validation blng_serv_code" +addl_serv_code);

			order_cat_code = request.getParameter("order_cat_code");	
			if(order_cat_code==null) order_cat_code="";					
			//System.out.println("validation order_cat_code" +order_cat_code);

			ord_catlog_count = request.getParameter("ord_catlog_count");	
			if(ord_catlog_count==null) ord_catlog_count="";					
			//System.out.println("validation ord_catlog_count" +ord_catlog_count);

			ord_i = request.getParameter("ord_i");	
			if(ord_i==null) ord_i="";					
			//System.out.println("validation ord_i" +ord_i);

			checked_val = request.getParameter("checked_val");	
			if(checked_val==null) checked_val="";					
			//System.out.println("validation checked_val" +checked_val);
			String query_dep_serv="";

			try{		
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				pstmt=con.prepareStatement(query_date);
				rst2 = pstmt.executeQuery();
				if (rst2!=null)
				{
				   if (rst2.next())
				   {
						 currdate = rst2.getString(1);
				   }
				}

				if (rst2 != null)   rst2.close();
				if (pstmt != null)   pstmt.close();
				

			}catch(Exception e)
			{
				System.out.println("error in date");
			}

			try{
				String sqlblngclass="{ call BLCOMMON.GET_BLNG_CLASS_CODE('"+str_facility_id+"','"+episode_type+"','"+episode_id+"','"+p_patient_id+"','',to_date('"+currdate+"','dd/mm/yyyy HH24:MI:SS'),?,?,?,?)}";

//				System.out.println("sqlblngclass @@@:"+sqlblngclass);
				call = con.prepareCall(sqlblngclass);
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.registerOutParameter(2,java.sql.Types.VARCHAR);
				call.registerOutParameter(3,java.sql.Types.VARCHAR);
				call.registerOutParameter(4,java.sql.Types.VARCHAR);
				call.execute();
				blng_class_code = call.getString(1);
				 if(blng_class_code==null) blng_class_code="";	
				error_level = call.getString(2);
				 if(error_level==null) error_level="";	
				sys_message_id = call.getString(3);
				 if(sys_message_id==null) sys_message_id="";	
				error_text = call.getString(4);
				 if(error_text==null) error_text="";	
				 call.close();
//				System.out.println("get blng class code " +blng_class_code);
//				System.out.println("get blng class error_level " +error_level);
//				System.out.println("get blng class sys_message_id " +sys_message_id);
//				System.out.println("get blng class error_text " +error_text);

			}catch(Exception rr)
			{
			  System.out.println("get blng class code " +rr);
			}

			try{		
				String query_code="SELECT Count(*)  FROM BL_OT_ADDL_SERV_DTL A, BL_OT_ADDL_SERV_HDR B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE	AND A.OPERATING_FACILITY_ID ='"+str_facility_id+"'	AND A.ORDER_CATALOG_CODE = '"+order_cat_code+"'	AND A.BLNG_CLASS_CODE = '"+blng_class_code+"'";	
				pstmt=con.prepareStatement(query_code);
				rst1 = pstmt.executeQuery();
				if (rst1!=null)
				{
				   if (rst1.next())
				   {
						 tot_blng_class_code = rst1.getInt(1);
				   }
				}
//					System.out.println("get blng class tot_blng_class_code " +tot_blng_class_code);

				if (rst1 != null)   rst1.close();
				if (pstmt != null)   pstmt.close();
				

			}catch(Exception e)
			{
				System.out.println("error in date");
			}
			if(tot_blng_class_code==0)
			{
				blng_class_code_orig = "**";
			}
			else{
				blng_class_code_orig = blng_class_code;
			}

			try{
				
				
				if(checked_val.equals("Y"))
				{
					query_dep_serv="select add_blng_serv_code from(select  ROWNUM RN,add_blng_serv_code from (select level, order_catalog_code, add_blng_serv_code,dep_blng_serv_code,CHARGE_IND, CHARGE_PERC	from BL_OT_ADDL_SERV_DTL where operating_facility_id = '"+str_facility_id+"'	and order_catalog_code = '"+order_cat_code+"' and blng_class_code = '"+blng_class_code_orig+"') connect by prior dep_blng_serv_code = add_blng_serv_code start with 	add_blng_serv_code = '"+addl_serv_code+"') where  RN>1";
				}
				else{
					

//						System.out.println("validation 2");
					query_dep_serv="select add_blng_serv_code from(select  ROWNUM RN,add_blng_serv_code from (select level, order_catalog_code, add_blng_serv_code,dep_blng_serv_code,CHARGE_IND, CHARGE_PERC	from BL_OT_ADDL_SERV_DTL where operating_facility_id = '"+str_facility_id+"'	and order_catalog_code = '"+order_cat_code+"' and blng_class_code = '"+blng_class_code_orig+"') connect by prior add_blng_serv_code = dep_blng_serv_code start with 	add_blng_serv_code = '"+addl_serv_code+"') where  RN>1";
				}
				
//						System.out.println("query_dep_serv @@@:"+query_dep_serv);
					PreparedStatement pst3=con.prepareStatement(query_dep_serv);
					ResultSet rst3 = pst3.executeQuery();
					if (rst3!=null)
					{

					   while (rst3.next())
					   {
							 add_blng_serv_code = rst3.getString(1);
						 	//a_dep_serv_code.add(add_blng_serv_code);
							str_add_blng_serv_code=str_add_blng_serv_code+add_blng_serv_code+"|";
					   }
					  // str_add_blng_serv_code=str_add_blng_serv_code+add_blng_serv_code+"|";
					   
					}
					
										
			

					if (rst3 != null)   rst3.close();
					if (pst3 != null)   pst3.close();
				
		
//					System.out.println("validation str_add_blng_serv_code" +str_add_blng_serv_code);

		}catch(Exception e)
				{
					System.out.println("error in qry" +e);
				}



            _bw.write(_wl_block3Bytes, _wl_block3);

//	if(checked_val.equals("Y"))
//	{

            _bw.write(_wl_block4Bytes, _wl_block4);

	//}
//else{

            _bw.write(_wl_block5Bytes, _wl_block5);

//	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(str_add_blng_serv_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_cat_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ord_catlog_count));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ord_i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(checked_val));
            _bw.write(_wl_block11Bytes, _wl_block11);



			}catch(Exception ee)
			{
			  System.out.println("Error in edit Adhoc disc " +ee);
			}
			finally 
			{
				if(con!=null)
				{
					ConnectionManager.returnConnection(con, request);
				}
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
