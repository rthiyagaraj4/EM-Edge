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
import java.util.*;
import com.ehis.util.*;

public final class __vieweventsebillshowdtloption extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/ViewEventseBillShowDtlOption.jsp", 1709122250618L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'JavaScript\' src=\'../../eXH/js/Validate.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\n<script language=\"JavaScript\">\n \n\nfunction onSelectStandardType()\n{\t\t\t\t\t\t\t\t\t  \n\tvar\telement_id=document.forms[0].element_id.value;\n\tvar element_desc=\'\';\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar tab11=document.getElementById(\"tab1\");\n\t//var stnd_code=document.forms[0].Standardcode_combo.value;\n\t//var seg_type=document.forms[0].segment_type.value;\n\tvar appl_id=document.forms[0].application.value;\n    var fun_id=document.forms[0].fun_id.value;\n\n /*   if(fun_id==\'SWTCHTRANS\')\n\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t   parent.frames[2].document.location.href=\'../../eXH/jsp/DataElementCrossRefApplicationElementSetupMain.jsp?applicationid=\'+appl_id+\'&element_id=\'+element_id+\'&element_desc=&fun_id=\'+fun_id;  \t     \n\t}\n\t*/\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t \n}\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\n/*\nfunction onSelectStandardTypeForm()\n{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \nvar\telement_id=\'\';\nvar element_desc=\'\';\nvar tab11=document.getElementById(\"tab1\");\t\t\t\t\t\t\t\t\t   \nvar stnd_code=document.forms[0].Standardcode_combo.value;\nvar seg_type=document.forms[0].segment_type.value;\nvar appl_id=document.forms[0].application.value;\t\t\t\t\t \n\n \n\nif(appl_id==\'\')\n{ \n\talert(getMessage( \'XH1003\'));\n\tparent.parent.frames[0].document.forms[0].appli.focus();\n\treturn;\n}\n\n/*parent.frames[2].document.location.href=\'../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp?applicationid=\'+appl_id+\'&segment_type_id=\'+seg_type+\'&standard_code=\'+stnd_code+\'&element_id=&element_desc=\';*/\n /*\nparent.frames[2].document.location.href=\'../../eXH/jsp/DataElementCrossRefApplicationElementSetupMain.jsp?applicationid=\'+appl_id+\'&segment_type_id=\'+seg_type+\'&standard_code=\'+stnd_code+\'&element_id=&element_desc=\';\n\n}\n\t\t\t\t\t\t\t\t\t\t\t\t\t \n\n\nfunction funPrev()\n{\n\tvar stnd_code=document.forms[0].Standardcode_combo.value;\n\t\tvar seg_type=document.forms[0].segment_type.value;\n\t\t\tvar appl =  this.document.forms[0].application.value; \n\t\tvar dialogHeight = \"125\";\t\t\t\t\t\t\t\t\t  \nvar dialogWidth  = \"125\";\nvar dialogTop    = \"115\";\nvar dialogLeft   = \"115\";\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\nvar arguments  =new Array();\n\tvar url=\"../../eXH/jsp/DataElementCrossRefApplicationElementSetupPreview.jsp?applicationid=\"+appl+\"&segment_type_id=\"+seg_type+\"&standard_code=\"+stnd_code;; \n window.showModalDialog(url,arguments,features);  \n} */\n\nfunction dispResult(obj){\n//\t  alert(\"Result MsgStat : \"+parent.frames[1].document.forms[0].msg_status.value);\n//\t  alert(\"Result EvntTyp : \"+parent.frames[1].document.forms[0].eventtype.value);\n\t  var index\t\t= obj.options.selectedIndex;\n\t  var Col    = obj.options[index].value;\n\t  var ColText    = obj.options[index].text;\n  \t  var ToCols = document.forms[0].ToCols.value;\n\t  var NewColList = \"\";\n//\t  alert(\"ColText : \"+ColText.substring(0,4));\n\t  if(ColText.substring(0,4)==\'Show\'){\n\t\t  \t  NewColList = ToCols+\",\"+Col;\n\t  }else  if(ColText.substring(0,4)==\'Hide\'){\t\t  \n               arr=ToCols.split(\',\'+Col);\n\t\t\t   NewColList = arr[0]+arr[1];\n\t  }\n\t  var msg_status = parent.frames[1].document.forms[0].msg_status.value;\n\t  var eventtype = parent.frames[1].document.forms[0].eventtype.value;\n//\t  alert(\"msg_status : eventtype \"+msg_status+\'\'+eventtype);\n\t  parent.frames[1].location.href=\'../../eXB/jsp/ViewEventseBillResult.jsp?NewColList=\'+NewColList+\'&msg_status=\'+msg_status+\'&eventtype=\'+eventtype;\t  \n\t  parent.frames[0].location.href=\'../../eXB/jsp/ViewEventseBillShowDtlOption.jsp\';\t //parent.frames[0].location.href=\'../../eXB/jsp/ViewEventseBillResult.jsp?NewColList=\'+NewColList+\'&fun_idapp=\'+document.forms[0].fun_idapp.value+\'&event_type=\'+event_type+\'&stnd_code=\'+stnd_code;     \n\n}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</HEAD>\n<!-- onLoad=\"onSelectStandardType()\" -->\n<BODY  leftmargin=0 topmargin=0   onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' >\n\n<form name=\"application_element_setup_form\" id=\"application_element_setup_form\">\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td width=\'30%\'></td>\n\t<td width=\'25%\'></td>\n\t<td width=\'10%\'></td>\t\t\t\t\t\t\t\t\t\t   \n\t<td width=\'20%\'></td>\n</tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n<tr>\n<td width=\'40%\'></td>\n<td class=label align=center colspan=2>\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<select class=\'select\' name=\'ShowHideCol\' id=\'ShowHideCol\'  style=\"width:200\" onChange=\'dispResult(this)\'>\n <option value=\'\' selected>-------Show/Hide Columns-------</option>\t\t\t\t \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'   >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</select> <!--<img src=\'../../eCommon/images/mandatory.gif\' align=middle> --> </td> \n\t<td>\n    </td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n <td></td>\n</tr>\n<tr>\n\t<td width=\'30%\'></td>\n\t<td width=\'10%\'></td>\n\t<td width=\'40%\'></td>\n\t<td width=\'20%\'></td>\t\t\t\t   \n</tr>\n</table>\n           \t\t\t\t\t\t\t\t\t\t\t\t\t  \n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=\"hidden\" name=\'code\' id=\'code\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'/>\n<input type=\"hidden\" name=\'ToCols\' id=\'ToCols\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'/>\n<input type=\"hidden\" name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'/>\n<input type=\"hidden\" name=\'fun_id\' id=\'fun_id\' id=fun_id value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\n<input type=\"hidden\" name=\'msg_status\' id=\'msg_status\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n<input type=\"hidden\" name=\'eventtype\' id=\'eventtype\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n\n</form>\n\n</BODY>\n</HTML>\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t    \n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
 //String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
String function_name="Application Level";
Connection con=null;															 
Statement stmt = null;																				  
ResultSet rs  = null;						 									  
ResultSet rs1  = null;												   		   
																							  
//String defaultval = "";										   
String code_yn="";																		    
//String version_no="";
//String application_id="";
//String ele_id=XBDBAdapter.checkNull(request.getParameter("elemnt_id"));
String fun_id=XBDBAdapter.checkNull(request.getParameter("fun_id")); 	 
//	System.out.println("ViewEventseBillShowDtlOption.jsp fun_id : "+fun_id);
String msg_status = XBDBAdapter.checkNull(request.getParameter("msg_status"));
String eventtype = XBDBAdapter.checkNull(request.getParameter("eventtype"));
String ToCols = "";


            _bw.write(_wl_block9Bytes, _wl_block9);
																	 	    
try			 														  
{
	con=ConnectionManager.getConnection();
//	String qry = "SELECT * FROM XB_EVENT_APPL_MESSAGE_XL_VW  ";			
String qry = "SELECT APPLICATION_ID, APPLICATION_NAME, FACILITY_NAME, MESSAGE_ID, FACILITY_ID, MESSAGE_DATE, EVENT_TYPE, PATIENT_ID, MERGED_PATIENT_ID, EPISODE_TYPE, EPISODE_ID, VISIT_ID, ACCESSION_NUM, ACTION_TYPE, LAST_PROC_DATE, EVENT_STATUS, NOT_REQ_REASON, ADDED_BY_ID, ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, EXT_ACCESSION_NUM, MESSAGE_STATUS, MESSAGE_STATUS_DESC, OUTBOUND_COMM_MODE, PROTOCOL_LINK_ID, SOLICITED_YN, ERR_MSG, MESSAGE_LENGTH, LAST_COMM_START_TIME, LAST_COMM_END_TIME, LAST_COMM_RETRIES, QUERY_ID, STATUS_TEXT, OUTBOUND_FILE_NAME, MESSAGE_TEXT,SYS_DEF_MESSAGE_TEXT,MESSAGE_TEXT,MESSAGE_LENGTH,LAST_COMM_START_TIME,LAST_COMM_END_TIME,LAST_COMM_RETRIES,QUERY_ID,STATUS_TEXT,OUTBOUND_FILE_NAME,'' INV_NO,'' INV_DATE,''  INV_AMOUNT,'' VISIT_DATE,'' PATIENT_NAME,'' PATIENT_TYPE,'' CARD_ID, '' CARD_ISSUE_DATE,'' CITIZEN_ID FROM XB_EVENT_APPL_MESSAGE_XL_VW "; 

	stmt = con.createStatement();		   
	 rs = stmt.executeQuery(qry);	
	 ResultSetMetaData rsmd = rs.getMetaData();
	 int col = rsmd.getColumnCount();

	String DataLinestr="";
	Pattern Regex=null;
	String Colstatus = "";
	String ColVal = "";

	 try{
			 File file = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );
//			 boolean exists = file.exists();	
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			 DataLinestr = br.readLine();
			 br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
       }
//			System.out.println("ViewEventseBillDtlsResultPage.jsp DataLinestr :"+DataLinestr);
		try{
			Regex = Pattern.compile("\\,",Pattern.MULTILINE);
		}
		catch(Exception e)
		{
			System.out.println("erorr"+e);
		}															    


		String[] array=Regex.split(DataLinestr);
	
		for(int i=0;i<array.length;i++)
		{
			ToCols = ToCols+array[i]+",";	
		}
			ToCols = ToCols.substring(0,ToCols.length()-1);
	

            _bw.write(_wl_block10Bytes, _wl_block10);

	for (int i=1; i <= col; i++)
	{
		for(int j=0;j<array.length;j++)
		{
//			String name=array[j].replaceFirst("_"," ");
//			System.out.println("Text Col : "+array[j]);
//			System.out.println("rsmd.getColumnName(i) : "+rsmd.getColumnName(i));			
				if(array[j].equals(rsmd.getColumnName(i)) ){
//				 System.out.println("equals");
                  Colstatus = "Hide";
				}
				else{
					Colstatus = "Show";
				}
				if(Colstatus.equals("Hide")) break;			
		}
			if(!Colstatus.equals("Hide")){ 
			Colstatus = "Show";
			}
			ColVal = Colstatus+" "+rsmd.getColumnName(i);
			//		System.out.println("ColVal : "+ColVal);
	 
	       if(rsmd.getColumnName(i).equals("EVENT_STATUS") || rsmd.getColumnName(i).equals("MESSAGE_STATUS") || rsmd.getColumnName(i).equals("MESSAGE_ID") || rsmd.getColumnName(i).equals("APPLICATION_ID") || rsmd.getColumnName(i).equals("EVENT_TYPE") || rsmd.getColumnName(i).equals("MESSAGE_DATE")|| rsmd.getColumnName(i).equals("FACILITY_ID")||rsmd.getColumnName(i).equals("ACCESSION_NUM")){  
			 
			}
			else{
  	 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rsmd.getColumnName(i)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ColVal));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
	}
            _bw.write(_wl_block14Bytes, _wl_block14);

}catch(Exception e1)
{
	System.out.println("ViewEventseBillShowDtlOption.jsp ERROR:"+e1.toString());
}


            _bw.write(_wl_block15Bytes, _wl_block15);

		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(code_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ToCols));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fun_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(eventtype));
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
