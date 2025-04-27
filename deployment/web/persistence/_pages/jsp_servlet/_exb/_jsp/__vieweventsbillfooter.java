package jsp_servlet._exb._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXB.XBDBAdapter;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import eXB.*;
import java.util.*;
import com.ehis.util.*;

public final class __vieweventsbillfooter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/ViewEventsBillFooter.jsp", 1709122250102L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD> \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\' type=\'text/css\'></link>\n<style>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tdiv {float: left}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t.testSty\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t{\n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style>\n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script> \t\t \n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\t\t\t\t\t\t\t\t\t    \n<script Language=\"JavaScript\"  src=\"../../eXH/js/Validate.js\" ></script>\t\t\t\t\t\t    \n<script Language=\"JavaScript\"  src=\"../../eCommon/js/common.js\" ></script>\n<Script Language=\"JavaScript\"  src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\'javascript\' src=\'../../eXB/js/ViewEventsOutbound.js\'></script>\n<script language=\'javascript\' src=\'../../eXB/js/ViewEvents.js\'></script>\n<script language=\"JavaScript\">\t\t\n\n</script>\n\n<BODY  leftmargin=0 topmargin=0  bgcolor=\'#F0F0F2\' onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"ApplicationEventListForMessageTypeForm\" id=\"ApplicationEventListForMessageTypeForm\" target=\'messageFrame\' method=\'post\' >\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<input type=hidden name=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' id=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' > </td>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n </table>\n </div>\n\n<table width=\'100%\' >\n    <tr> </tr>\t  <tr> </tr>\t    <tr> </tr>\n\t\t<tr>\n\t\t\t<td  class=label >Count  </td> <td> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n\t\t\t<td width=\'55%\' > </td> <td class=label >Cumulative Sum  <input type = \"text\" size=\"10\"  name=\'cum_amount\' id=\'cum_amount\' value = \'0\' >\t&nbsp;&nbsp; <input type = \"button\" name=\"Show Total Sum\" id=\"Show Total Sum\" value=\' Show Total Sum \'  title=\'Show Total Sum\' onClick=\'ShowTotal();\'> \t</td>\n\t\t</tr>\n   <tr> </tr>\n</table>\t \n\n<div id=\'export\' style=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr>\n\t\t<td class=\"CAGROUP\" width=\'5%\'> <A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"genExport();\" TITLE=\"Export\" > Export\t</A> </td>\n\t</tr>\n</table>\t \n<div>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n<input type=hidden name=message_type value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n<input type=hidden name=rsCount value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n<input type=hidden name=QryCols value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n<input type=hidden name=Tot_Inv_Amount value=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = ((String)session.getAttribute("LOCALE")); 
locale = "en"; 
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con=null;
Statement stmt1=null;
ResultSet rs1=null;
int rsCount = 0;
String QryCols = "";
String emptyString = "";
int Tot_Inv_Amount = 0;
//String disabled = "disabled";
String styleExport = "display:none";
//String strBeanName = XBUnsolicitedEventsControllerBean.strBeanName;  


            _bw.write(_wl_block8Bytes, _wl_block8);
																	 	    
try			 	
{
	String msg_dt1= null;
	String msg_dt2= null;
	String msg_id1= null;
	String msg_id2= null;
	String applnname= null;
	String eventtype= null;
	String comm_mode= null;
	String facility= null;
	String event_status = null;
	String msg_status= null;
	String protocol_link_name= null;
//	String purge_status= null;
	String dispMode= null;
	String interface_module= null;

	msg_dt1 = XBDBAdapter.checkNull(request.getParameter("msg_dt1"));
	msg_dt2 = XBDBAdapter.checkNull(request.getParameter("msg_dt2"));
	msg_id1 = XBDBAdapter.checkNull(request.getParameter("msg_id1"));
	msg_id2 = XBDBAdapter.checkNull(request.getParameter("msg_id2"));
	applnname = XBDBAdapter.checkNull(request.getParameter("applnname"));
	eventtype = XBDBAdapter.checkNull(request.getParameter("eventtype"));
//		System.out.println("eventtype : "+eventtype);
	comm_mode = XBDBAdapter.checkNull(request.getParameter("comm_mode"));
	facility = XBDBAdapter.checkNull(request.getParameter("facility"));
	event_status = XBDBAdapter.checkNull(request.getParameter("event_status"));
	msg_status = XBDBAdapter.checkNull(request.getParameter("msg_status"));
	protocol_link_name = XBDBAdapter.checkNull(request.getParameter("protocol_link_name"));
	dispMode = XBDBAdapter.checkNull(request.getParameter("dispMode"));
	interface_module = XBDBAdapter.checkNull(request.getParameter("interface_module"));

//		System.out.println("msg_status : "+msg_status);
	if(msg_status.equals("R") && !eventtype.equals("") ){
	//	disabled = "";
		styleExport="display:block";
	}
    
	String NewColList = XBDBAdapter.checkNull(request.getParameter("NewColList"));
//		System.out.println("NewColList : "+NewColList);
	con=ConnectionManager.getConnection();
//	String qry = "SELECT * FROM XB_EVENT_APPL_MESSAGE_XL_VW  ";				   

	String ResultQry = "";
	String DataLinestr="";
	Pattern Regex=null;
//	String Colstatus = "";
//	String ColVal = "";
//	String EvntStatusColor = "../../eXH/images/black_square.jpg";
//	String MsgStatusColor = "../../eXH/images/blue_square.jpg";

	 try{
		 File file1 = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );

           if(NewColList.length()>0){
		 			FileOutputStream fileoutput = new FileOutputStream(file1);
					fileoutput.write(NewColList.getBytes());
					if (fileoutput != null)  fileoutput.close();	
		   }
	   		 File file2 = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );
//			 boolean exists = file2.exists();	
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
			 DataLinestr = br.readLine();
			 br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
       }
//			System.out.println("ViewEventseBillDtlsResultPage.jsp DataLinestr :"+DataLinestr);
		try{
			Regex = Pattern.compile("\\,",Pattern.MULTILINE);
// System.out.println("ViewEventseBillDtlsResultPage.jsp Regex :"+Regex);

		}
		catch(Exception e)
		{
			System.out.println("erorr"+e);
		}															    

		String[] array=Regex.split(DataLinestr);
//	    System.out.println("array.length : "+array.length);
		for(int i=0;i<array.length;i++)
		{
// String name=array[i].replaceFirst("_"," ");
	if(array[i].equals("INV_NO")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)-1)  INV_NO,";
			}
			else  if(array[i].equals("INV_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)-1)  INV_DATE,";
			}
			else if(array[i].equals("INV_AMOUNT")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)-1) INV_AMOUNT,";
			}
			else if(array[i].equals("VISIT_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)-1)  VISIT_DATE,";
			}
			else if(array[i].equals("PATIENT_NAME")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)-1)  PATIENT_NAME,";
			}
			else if(array[i].equals("PATIENT_TYPE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)-1) PATIENT_TYPE,";
			}
			else if(array[i].equals("CARD_ID")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)-1)  CARD_ID,";
			}
			else if(array[i].equals("CARD_ISSUE_DATE")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)-1)  CARD_ISSUE_DATE,";
			}
			else if(array[i].equals("CITIZEN_ID")){
				QryCols = QryCols+"SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1)  CITIZEN_ID,";
			}
			else{
				QryCols = QryCols+array[i]+",";	
			}
		}
		QryCols = QryCols.substring(0,QryCols.length()-1);

//		System.out.println("ViewEventsBillFooter.jsp QryCols : "+QryCols);
		ResultQry = "Select "+QryCols+" FROM XB_EVENT_APPL_MESSAGE_XL_VW WHERE  EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  /* AND MESSAGE_STATUS = NVL('H',MESSAGE_STATUS) AND EPISODE_TYPE='O'  AND PATIENT_ID like 'E%' AND ROWNUM<=3  */ ORDER BY MESSAGE_ID"; 
	// AND EVENT_STATUS = NVL('S',EVENT_STATUS)
		System.out.println("ResultQry : "+ResultQry);
		stmt1 = con.createStatement();		 
		 rs1 = stmt1.executeQuery(ResultQry);	
		
		int amount = 0;

		while(rs1.next()) {
	
		for(int i=0;i<array.length;i++)
		{
			String name=array[i].replaceFirst("_"," ");
			
			if(name.equals("INV AMOUNT")) { 
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf("inv_amnt_"+rsCount));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf("inv_amnt_"+rsCount));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs1.getString("INV_AMOUNT") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
					amount = Integer.parseInt(rs1.getString("INV_AMOUNT"));
					 Tot_Inv_Amount = Tot_Inv_Amount+amount;
			 }
		}
	
            _bw.write(_wl_block13Bytes, _wl_block13);

	rsCount++;
} // end of rs.next()
 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rsCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(styleExport));
            _bw.write(_wl_block16Bytes, _wl_block16);

}catch(Exception e1)
{																							 
		System.out.println("ViewEventseBillResult.jsp Exc : "+e1.toString());
		e1.printStackTrace(System.err);
}
finally									 
{
			try{												  
			if(stmt1!=null)stmt1.close();							 
			if(rs1!=null)rs1.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("Exception in ViewEventseBillResult.jsp :  "+e);
				}			
}
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( emptyString ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rsCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(QryCols)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Tot_Inv_Amount));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
