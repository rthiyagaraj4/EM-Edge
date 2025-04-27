package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __labtestcodesearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/LabTestCodeSearchResult.jsp", 1722863761415L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'> </script>\n\t<script language=\"javascript\" src=\"../../eMR/js/LabTestCodesForNotifDis.js\"></script>\n</head>\n<script>\nfunction submitPrevNext(from, to){\n\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t\t\n\t    document.forms[0].submit();\n\t\t\n\t}\n function RemSelectAll(obj, i)\n{\n\t\n\n\tif(obj.checked == false)\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"Y\";\n\telse\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"N\";\n}\n\n\n\nfunction chkForSelectAll(start,end)\n{\n\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\')\n\t{\n\tdocument.forms[0].chkAll.checked=true;\n\t\n\t\n\t}\n\n}\n\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t <body  OnMouseDown=\"CodeArrest();\" onKeyDown=\'lockKey()\'  onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\'  class=\'CONTENT\'>\n\t\t<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eMR/jsp/LabTestCodeSearchResult.jsp\' method=\'post\' > \n\t\t<table  width=\'90%\' border=\'0\' align=\'center\'>\n\t\t<tr>\n\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t <input type=\'hidden\' name=\'selectCHk\' id=\'selectCHk\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t<input type=hidden name=\'notifyDisCode\' id=\'notifyDisCode\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t<input type=hidden name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t<input type=hidden name=\'searchCriteria\' id=\'searchCriteria\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'selectchkALL\' id=\'selectchkALL\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\n\t\t\t<table  align=\'right\'>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<br>\n\t\t\t\t<br>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t\n\t\t\t<!-- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" -->\n\t\t\t <tr><td width=\'20%\' height=\'30\' align=\'center\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td width=\'60%\' height=\'30\' align=\'center\'  class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td> <td width=\'20%\' height=\'30\' align=\'center\' class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\n\t<tr>\n\t\t <td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" name=\'chk";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onclick=\"RemSelectAll(this, ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =");\"><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'removeCode";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\"\"><input type=\'hidden\' name=\'Code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'Code";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></td>\n</tr>\t\n\n\t ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet LabTestforNotifyDise= null;synchronized(session){
                LabTestforNotifyDise=(webbeans.eCommon.RecordSet)pageContext.getAttribute("LabTestforNotifyDise",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(LabTestforNotifyDise==null){
                    LabTestforNotifyDise=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("LabTestforNotifyDise",LabTestforNotifyDise,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String from               = request.getParameter("from") ;
String to                 = request.getParameter("to");
//import
    String selectchkALLChk="";
	String selectchkALL = checkForNull(request.getParameter("selectchkALL") );
	if(selectchkALL.equals("Y"))
	selectchkALLChk="checked";
	else
	selectchkALLChk=" ";
	
	
//import
	String  req_start   =   "", req_end     =   "";
	   String  checkedOnes         =   "";
	   String removeCode = "";


String term_set_id        =request.getParameter("term_set_id");
String flagSelect         = request.getParameter("fromSearch");
String serachCriteriaValue=request.getParameter("serachCriteriaValue");
String searchCriteria     =request.getParameter("search_criteria");
String notifyDisCode      =request.getParameter("notifyDisCode");
String dftchkAttribute="";
String selectCHkChecked   ="";
String selectCHk          =checkForNull(request.getParameter("selectCHk"));
if(selectCHk.equals("Y"))
selectCHkChecked          ="checked";
else
selectCHkChecked          =" ";
int maxRecord             = 0;
int start                 = 0 ;
int end                   = 0 ;
int i                     =1;



if (from == null){start = 0 ;}
else {start = Integer.parseInt(from); }
if (to == null){  end = 12 ; }else{end = Integer.parseInt( to ) ;  }
     
	 req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");


	    
		String effStatus="";
		//Statement stmt3 = null;
		PreparedStatement stmt3=null;
		ResultSet rstlRs3 = null;
	 
	 effStatus=request.getParameter("effStatus") ;
		if(effStatus == null) effStatus="";
			Statement stmt=null;
			ResultSet rs=null ;

		Connection con = null;
	  
	  
	  try{ 

con = ConnectionManager.getConnection(request);		



		if(flagSelect !=null){  
	        LabTestforNotifyDise.clearAll() ;
	        String sqlinsVals="SELECT TEST_CODE FROM  MR_LABTEST_FOR_NOTIFY_DIS WHERE NOTIFY_DISEASE_CODE=?";
			//stmt3=con.createStatement();
			stmt3 = con.prepareStatement(sqlinsVals);
			stmt3.setString(1,notifyDisCode);
			rstlRs3 = stmt3.executeQuery();
			if(rstlRs3 !=null){
			  while(rstlRs3.next()){ 
			
				LabTestforNotifyDise.putObject(rstlRs3.getString(1));
			   }
			}
	   	}

		if(from != null && to != null){
            int j=0;
            for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
                if(request.getParameter("chk"+(i)) != null){  
                    checkedOnes = request.getParameter("chk"+(i));
                    if(!(LabTestforNotifyDise.containsObject(checkedOnes)))
                      LabTestforNotifyDise.putObject(checkedOnes);
                    j++;
                  }else{
                   }
			    removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))	{
					String spclt_Code = request.getParameter("Code"+(i));
					if((LabTestforNotifyDise.containsObject(spclt_Code)))	{
						int removeCodeIndex = LabTestforNotifyDise.indexOfObject(spclt_Code) ;
						LabTestforNotifyDise.removeObject(removeCodeIndex);
				   	}
				}				 
            }						
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
          }
		i = 1 ;
		String classValue="";
		String chkAttribute=""; 
		StringBuffer sql = new StringBuffer() ;  
		sql.append("SELECT '"+notifyDisCode+"' , TEST_CODE  TEST_CODE, long_desc test_cod_desc, 'I' db_action from rl_test_code WHERE (status is null or status = 'A')  and test_code NOT IN ( select test_code FROM MR_LABTEST_FOR_NOTIFY_DIS WHERE NOTIFY_DISEASE_CODE='"+notifyDisCode+"') ");
		

		if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_code"))
			sql.append(" and Upper(TEST_CODE) LIKE Upper('"+serachCriteriaValue+"%')");
		else if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_desc"))
			sql.append(" and Upper(long_desc) LIKE Upper('"+serachCriteriaValue+"%')");
		
	 	 
	 	 sql.append("UNION ALL SELECT   '"+notifyDisCode+"', a.test_code test_code, b.long_desc test_code, 'U' db_action FROM MR_LABTEST_FOR_NOTIFY_DIS a, RL_TEST_CODE b WHERE a.notify_disease_code = '"+notifyDisCode+"' AND b.test_code = a.test_code ");

		if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_code"))
			sql.append(" and Upper(b.TEST_CODE) LIKE Upper('"+serachCriteriaValue+"%')");
		else if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_desc"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('"+serachCriteriaValue+"%')");
		
		sql.append("  order by 3");	
	
	

	
	try{  
	 stmt=con.createStatement();

	 rs=stmt.executeQuery(sql.toString());
	}catch (Exception e){
		e.printStackTrace();
		//out.println(e); 		 
	}
 
	if (start != 0){
		for(int j=1; j<=start; i++,j++){
			rs.next() ;
		}
	}
	 
	while(i<=end && rs.next() ) { 	 
	  if(maxRecord == 0){ 
 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(selectCHk));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(notifyDisCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(notifyDisCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(selectchkALL));
            _bw.write(_wl_block20Bytes, _wl_block20);

			if ( !(start <= 1)) {
				out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
		    
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
			
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
/*
			
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
*/	
	    String test_code=rs.getString("test_code");
	     String test_cod_desc=rs.getString("test_cod_desc");
		 
		 if(LabTestforNotifyDise.containsObject(test_code)) {
			chkAttribute = "CHECKED";
		  }else{
			chkAttribute="";
		}
		int recordIndex = LabTestforNotifyDise.indexOfObject(test_code);
		if(recordIndex!=-1)
		 if(chkAttribute.equals("CHECKED"))   
			LabTestforNotifyDise.removeObject(recordIndex); 
				
	
	    if(i%2 == 0)
			classValue="QRYEVEN";  
		else
		   classValue="QRYODD"; 
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(test_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(test_cod_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(test_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(test_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
 i++;
		maxRecord++;
		
		if ( maxRecord < 12 || (!rs.next()) )
				{ 
					
            _bw.write(_wl_block41Bytes, _wl_block41);
 
				}
				else
				{  
            _bw.write(_wl_block42Bytes, _wl_block42);

				}
				  
	if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}
	
	}
	
	if(maxRecord == 0)
				{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}
	
	} catch(Exception e){/* out.print(e); */e.printStackTrace();}
	 finally
	 {
	  if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
							ConnectionManager.returnConnection(con,request);
				session.setAttribute("LabTestforNotifyDise", LabTestforNotifyDise);
	 
	 
	 }
	
            _bw.write(_wl_block43Bytes, _wl_block43);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.NotifyDiseases.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TEST_CODE.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TEST_DES.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Select.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
