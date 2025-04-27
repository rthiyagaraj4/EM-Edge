package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __vieworderformat extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewOrderFormat.jsp", 1736166400000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ViewOrder.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<FORM METHOD=POST ACTION=\"\">\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<table cellpadding=3 cellspacing=0 border=0 align=center width=\'100%\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<td class=label  width=\'25%\' style=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"><font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td width=\'25%\' colspan=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\'fields\' style=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"><font size=1><TEXTAREA NAME=\'\' ROWS=\'3\' COLS=\'30\' readOnly>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TEXTAREA></td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<td class=label   width=\'25%\' style=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<td  width=\'25%\' colspan=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><font size=1><input type=checkbox value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="></td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td width=\'25%\' class=\"data\" colspan=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><font size=1><B>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</table>\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
-----------------------------------------------------------------------
Date       Edit History      Name        Rev.Date   Rev.By		Description
-----------------------------------------------------------------------
?             100            ?           	    				created
28/10/2011    IN029395      Chowminya G      					Incident No: IN029395 - <exception on dateutil>  
30/01/2014    IN045798		Chowminya    30/01/2014 Chowminya   The Original alignment of the Order format Items are getting changed in the Order format screen    
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);




	request.setCharacterEncoding("UTF-8");

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String orderId = request.getParameter("orderId");
	
	String auditTrailYN = request.getParameter("auditTrail")==null?"":(String)request.getParameter("auditTrail"); //IN049419
	String action_seq_num = request.getParameter("action_seq_num")==null?"":(String)request.getParameter("action_seq_num"); //IN049419

	String lineId = request.getParameter("lineId")==null?"":(String)request.getParameter("lineId");
//out.println("<script>alert("+lineId+");</script>");
//out.println("<script>alert('"+orderId+"');</script>");
	String called_from = request.getParameter("called_from");
	if(called_from==null) called_from = "";
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	ArrayList order_format_dtl = new ArrayList();

	if(lineId == null || lineId.equals("null")) lineId = "";
	if(lineId.equals("")) 
	{
		//IN049419 Start.
		//order_format_dtl = bean.getOrderFormatDetail( orderId ) ;
		if(auditTrailYN.equals("Y"))
			order_format_dtl = bean.getOrderFormatDetailAuditTrail( orderId, action_seq_num) ;
		else
			order_format_dtl = bean.getOrderFormatDetail( orderId ) ;
		//IN049419 End.
	}else
	{
		//IN049419 Start.
		//order_format_dtl = bean.getOrderFormatLineDetail(orderId,lineId,called_from) ;
		if(auditTrailYN.equals("Y"))
			order_format_dtl = bean.getOrderFormatLineDetailAuditTrail( orderId, action_seq_num,lineId,called_from) ;
		else
			order_format_dtl = bean.getOrderFormatLineDetail(orderId,lineId,called_from) ;
		//IN049419 End.
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
 

	int j=0;
	String disabled = " disabled ";
	String checked = "";
	String colspan = "0";
	String order_format_field_values="";
	int transplant_exists = 0;
	String transplant_checked = "";
	String display_transplant = "";
	String display_hdr = "";//IN045798
	String disp = "";//IN045798

	for(int i=0; i<order_format_dtl.size(); i++)
	{
		/*if(i%2 == 0 )
		{
			out.println("<tr>");
			j++;
		}*/ //IN045798 Commented
		display_hdr = "N"; //IN045798
		String record[] = (String[])order_format_dtl.get(i);
		record[0]=bean.checkForNull(record[0],"");
		record[1]=bean.checkForNull(record[1],"");
		record[2]=bean.checkForNull(record[2],"");
		record[3]=bean.checkForNull(record[3],"");
		record[4]=bean.checkForNull(record[4],"");
		//IN045798 - Start
		if(lineId.equals("")) 
			disp=bean.checkForNull(record[3],""); 
		else
			disp=bean.checkForNull(record[8],""); 
		
		if(record[0].equals("L"))
		{
			display_hdr = bean.getMultiPresentationSelection(record[4].trim()) ;
		}
		if (j == 2)
			j= 0;

		if(disp.equals("D")|| display_hdr.equals("Y"))
		{
			out.println("</tr><tr>");
			j=2;
		}else if(j == 0){
			out.println("</tr><tr>");
			j++;
		}else
			j++;
		//IN045798 - End
		if(record[0].equals("E"))
		{ 	
			if(!(record[2].trim().equals("")))//--[IN029395]
			{
				record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName);	
			}			
		}
		else if(record[0].equals("D"))
        {
			if(!(record[2].trim().equals("")))//--[IN029395]
			{
				record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMY","en",localeName);	
			}			
		}

		if(lineId.equals("")) 
		{
			order_format_field_values = bean.checkForNull(record[2],"")+" "+bean.checkForNull(record[4],"");
		}
		else
		{
			record[5]=bean.checkForNull(record[5],"");
			record[6]=bean.checkForNull(record[6],"");
			record[7]=bean.checkForNull(record[7],"");
			order_format_field_values = bean.checkForNull(record[2],"")+" "+bean.checkForNull(record[7],"");
		}
	
		if(lineId.equals("")) 
		{
			if(record[5].equals("TRANSPLANT_PAT_YN"))
			{
				transplant_exists++;
				if(record[0].equals("C"))
				{
 					if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
						transplant_checked = "";
					else transplant_checked = "checked";
				}
			}
			if(transplant_exists>0 &&transplant_checked.equalsIgnoreCase(""))
			{		
				if(record[5].equals("DONOR_BLOOD_GROUP")||record[5].equals("DONOR_RHESUS")||record[5].equals("TRANSPLANT_DATE"))
				{
					display_transplant="display:none";
				}
				else
				{
					display_transplant="display:";
				}
			}
			else
			{
				display_transplant="display:";
			}
		}
		else
		{
			if(record[4].equals("TRANSPLANT_PAT_YN"))
			{
				transplant_exists++;
				if(record[0].equals("C"))
				{
 					if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
						transplant_checked = "";
					else transplant_checked = "checked";
				}
			}
			if(transplant_exists>0 &&transplant_checked.equalsIgnoreCase(""))
			{		
				if(record[4].equals("DONOR_BLOOD_GROUP")||record[4].equals("DONOR_RHESUS")||record[4].equals("TRANSPLANT_DATE"))
				{
					display_transplant="display:none";
				}
				else
				{
					display_transplant="display:";
				}
			}
			else
			{
				display_transplant="display:";
			}
		}
		if(record[0].equals("A"))
		{  

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block11Bytes, _wl_block11);

				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
	
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(((record[2] == null) ? "" : record[2])));
            _bw.write(_wl_block15Bytes, _wl_block15);

							

			}else if(record[0].equals("C"))
			{
 				if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
					checked = "";
				else checked = "checked";
					//System.out.println("hello2");


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block11Bytes, _wl_block11);

				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			else 
			{
				

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block11Bytes, _wl_block11);

				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				/*if(record[1].contains("Pres"))
					{
						if(record[2].equals("1"))record[2] = "";
					}*/
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(colspan));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(display_transplant));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order_format_field_values));
            _bw.write(_wl_block25Bytes, _wl_block25);

			//IN045798 - Start
			if(disp.equals("D")|| display_hdr.equals("Y"))
			{
				out.println("</tr>");
			}
			//IN045798 - End
		}
	}

            _bw.write(_wl_block26Bytes, _wl_block26);

		putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
