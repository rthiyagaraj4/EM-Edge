package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;

public final class __bllogincashcountervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLogInCashCounterValidation.jsp", 1709114538572L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<body onLoad=\"transferctrl();\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t <script>\t\n\t   var strerrortext  = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n       alert(strerrortext);\n\t </script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t  <script>\n    \t  alert(getMessage(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'BL\'));\n\t  </script>\n    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\t\n\t\t\t\t\t\tvar strerrortext =  \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t\talert(strerrortext);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t   alert(2);\n    \t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'BL\'));\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<INPUT TYPE=\"HIDDEN\" name=\"strfacilityid\" id=\"strfacilityid\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<INPUT TYPE=\"HIDDEN\" name=\"user\" id=\"user\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<INPUT TYPE=\"HIDDEN\" name=\"CashCounterCode\" id=\"CashCounterCode\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<INPUT TYPE=\"HIDDEN\" name=\"shiftstartingat\" id=\"shiftstartingat\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<INPUT TYPE=\"HIDDEN\" name=\"obamt\" id=\"obamt\"\t   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\t\t  parent.frames[1].document.menu_form.cashcounter.value=\"\";\n\t\t\t  parent.frames[1].document.menu_form.shift_started_at.value=\"\";\n \t\t\t  parent.frames[1].document.menu_form.opening_balance.value=\"\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\n\t\t\tvar facilityid1=document.forms[0].strfacilityid.value;\n\t\t\tvar user1=document.forms[0].user.value;\n\t\t\tvar CashCounterCode1=document.forms[0].CashCounterCode.value;\n\t\t\tvar shiftstartingat1=document.forms[0].shiftstartingat.value;\n\t\t\tvar obamt1=document.forms[0].obamt.value;\n\t\t\n\t\t\tfunction transferctrl()\n\t\t\t{\n\t\t\t\t//com.ehis.util.DateUtils.convertDate(shiftstartingat,\"DMYHM\",\"en\",locale)\n\t\t\t\tparent.frames[1].document.menu_form.cashcounter.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\tparent.frames[1].document.menu_form.shift_started_at.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\tparent.frames[1].document.menu_form.opening_balance.value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</form>\t \n</body>\n</html>\n\n\n\n\t\t\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con = null;

	PreparedStatement pstmt = null;
		ResultSet rs = null;	

	request.setCharacterEncoding("UTF-8");
	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");	
	String locale	= (String)session.getAttribute("LOCALE");
    	
	String strfacilityid = request.getParameter("facility_id");
	String user = request.getParameter("login_user");
	String CashCounterCode = request.getParameter("strCashCounterCode");
//	System.out.println("CashCounterCode Val:"+CashCounterCode);
	String shiftstartingat="";
	String obamt="";
	String strerrorlevel	  = "";		
	String strsysmessageid	  = "";		
	String strerrortext		  = "";
	int noofdecimal = 2;
	try{
			con	=	ConnectionManager.getConnection(request);

			con.setAutoCommit(false);
			CallableStatement call = 
					con.prepareCall("{ call bl_cash_counter_check.get_shift_details (?,?,?,?,?,?,?)}");	
					call.setString(1,strfacilityid);
					call.setString(2,CashCounterCode);
					call.setString(3,user);

					call.registerOutParameter(4,java.sql.Types.VARCHAR);
					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	

					call.execute();									

					shiftstartingat	 = call.getString(4);	
					strsysmessageid	     = call.getString(5);		
					strerrorlevel		 = call.getString(6);		
					strerrortext		 = call.getString(7);		

					call.close();
					
					
					if ( shiftstartingat == null ) shiftstartingat = "";
					if ( strerrorlevel == null ) strerrorlevel = "";
					if ( strsysmessageid == null ) strsysmessageid ="";
					if ( strerrortext == null ) strerrortext ="";
//					System.out.println("shiftstartingat val"+shiftstartingat);
//					System.out.println("strerrorlevel val"+strerrorlevel);
//					System.out.println("strsysmessageid"+strsysmessageid);
//					System.out.println("strerrortext"+strerrortext);

					
		 if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
			{
			 
				 
			 if (strerrorlevel.equals("10") && !strerrortext.equals(""))
			{
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
   if(!strsysmessageid.equals(""))
    {
   
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block9Bytes, _wl_block9);

	 }
	}



					try
						{		
							pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
							
							rs = pstmt.executeQuery();	
							if ( rs.next() && rs != null ) 
								noofdecimal  =  rs.getInt(1);			
						}
						catch(Exception e) {System.out.println("4="+e.toString());}

						finally 
						{
							if (rs != null)   rs.close();
							if (pstmt != null) pstmt.close();		 		
						}	


				CallableStatement call1 =	
					con.prepareCall("{ call bl_cash_counter_check.cash_counter_ob_amt_dflt (?,?,?,?,?,?)}");	
					call1.setString(1,strfacilityid);
					call1.setString(2,CashCounterCode);
					call1.registerOutParameter(3,java.sql.Types.VARCHAR);
					call1.registerOutParameter(4,java.sql.Types.VARCHAR);	
					call1.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call1.registerOutParameter(6,java.sql.Types.VARCHAR);	

					call1.execute();									

					obamt					 = call1.getString(3);	

					
					CurrencyFormat cf = new CurrencyFormat();
					obamt = cf.formatCurrency(obamt, noofdecimal);	

					strsysmessageid	     = call1.getString(4);		
					strerrorlevel		 = call1.getString(5);		
					strerrortext		 = call1.getString(6);				
		
					call1.close();
					if ( obamt == null ) obamt = "";
					if ( strerrorlevel == null ) strerrorlevel = "";
					if ( strsysmessageid == null ) strsysmessageid ="";
					if ( strerrortext == null ) strerrortext ="";

					

			if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
			{
			 if (strerrorlevel.equals("10") && !strerrortext.equals(""))
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			if(!strsysmessageid.equals(""))
			{
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			}



		}
	catch(Exception e) 
					{
						con.rollback();
						//out.println(e);
						e.printStackTrace();
					}

	finally 
					{
						
						ConnectionManager.returnConnection(con, request);	
					}

	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(user ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(CashCounterCode ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shiftstartingat ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(obamt ));
            _bw.write(_wl_block19Bytes, _wl_block19);

	if (CashCounterCode.equals(""))
	{
	
            _bw.write(_wl_block20Bytes, _wl_block20);

	}
	else
	{
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(CashCounterCode ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(shiftstartingat,"DMYHM","en",locale)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(obamt ));
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
