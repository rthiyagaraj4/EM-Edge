package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __levelofcarefordependencydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/LevelOfCareForDependencyDetail.jsp", 1709116594278L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../js/CpMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\n<script>\n       \n\tfunction submitPrevNext(from, to){\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t    document.forms[0].submit();\n\t}\n\nfunction selectAll(Obj,start,end)\n{\n\tif(Obj.checked)\n\t{\n\tfor(var i=start;i<=end;i++)\n\t\t{\n\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\teval(\"document.forms[0].chk\"+i).checked=true;\n\t\t}\n\tvar level_of_care_code = document.forms[0].level_of_care_code.value;\n\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'LevelOfCareForDependencyDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'notCleared\'><input type=\'hidden\' name=\'level_of_care_code\' id=\'level_of_care_code\' value=\'\"+level_of_care_code+\"\'></form></BODY></HTML>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.form1.submit();\n\t}\n\telse\n\t{\n\t\tfor(var i=start;i<=end;i++)\n\t\t\t{\n\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\teval(\"document.forms[0].chk\"+i).checked=false;\n\t\t\t}\n\t\n\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'LevelOfCareForDependencyDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'clearAll\'></form></BODY></HTML>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.form1.submit();\n\t}\n}\n\nfunction chkForSelectAll(start,end)\n{\n\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\')\n\t{\n\tdocument.forms[0].chkAll.checked=true;\n\tselectAll(document.forms[0].chkAll,start,end)\n\t}\n\n}\n</script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =",";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =")\' class=\'CONTENT\' >\n<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eCP/jsp/LevelOfCareForDependencyDetail.jsp\' method=\'post\' >\n\n<table  width=90%\' border=0 align=\'center\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n<input type=hidden name=\'level_of_care_code\' id=\'level_of_care_code\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\' text-decoration=\'none\'>Previous</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' text-decoration=\'none\'>Next</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</td>\n</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<th width=\'60%\'><fmt:message key=\"Common.Dependency.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/></th>\n\t\t\t<th width=\'20%\'><fmt:message key=\"Common.selectall.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/> <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\'></th>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" name=\'chk";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n</table>\n</form>\n</body>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet LevelOfCareForDependency= null;synchronized(session){
                LevelOfCareForDependency=(webbeans.eCommon.RecordSet)pageContext.getAttribute("LevelOfCareForDependency",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(LevelOfCareForDependency==null){
                    LevelOfCareForDependency=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("LevelOfCareForDependency",LevelOfCareForDependency,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
		Statement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);
	String level_of_care_code=request.getParameter("level_of_care_code");
	String flagSelect = request.getParameter("fromSearch");


	        	if(flagSelect !=null)
	        	{
	        		 LevelOfCareForDependency.clearAll();
	        		 String sqlinsVals= " select dependency_code from cp_loc_for_dependency where level_of_care_code='"+level_of_care_code+"'";
					 stmt3=con.createStatement();
				     rstlRs3 = stmt3.executeQuery(sqlinsVals);
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						LevelOfCareForDependency.putObject(rstlRs3.getString(1));

					 }
				}
	
	        	}
	        
//	        int recordCount			=	0;

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(LevelOfCareForDependency.containsObject(checkedOnes)))
                                 LevelOfCareForDependency.putObject(checkedOnes);
                             j++;
                         }
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
					
String   sql  =" select '"+level_of_care_code+"', dependency_code,long_desc dependency_desc, 'I' db_action from cp_dependency where dependency_code not in(select dependency_code from cp_loc_for_dependency where level_of_care_code = '"+level_of_care_code+"') and eff_status = 'E' union all select '"+level_of_care_code+"', a.dependency_code, b.long_desc dependency_desc, 'U' db_action from cp_loc_for_dependency a, cp_dependency b where level_of_care_code = '"+level_of_care_code+"' and b.dependency_code = a.dependency_code order by 3";
							
				
try{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql);
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){out.println(e);}


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(start));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(end));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(level_of_care_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);

    if ( !(start <= 1)) {

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block14Bytes, _wl_block14);

    }
    if ( !((start+12) >= maxRecord )){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block15Bytes, _wl_block15);

    }

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(end));
            _bw.write(_wl_block19Bytes, _wl_block19);
	 
//		recordCount =	LevelOfCareForDependency.getSize();
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ 
			String dependency_code=rs.getString("dependency_code");
			
			String dependency_desc=rs.getString("dependency_desc");

			if(LevelOfCareForDependency.containsObject(dependency_code))  chkAttribute = "CHECKED";
			else
			chkAttribute="";

			int recordIndex = LevelOfCareForDependency.indexOfObject(dependency_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    LevelOfCareForDependency.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dependency_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dependency_code));
            _bw.write(_wl_block26Bytes, _wl_block26);

			i++;
			}		
			
			
			 }
			  catch(Exception e){
				  //out.print(e);//common-icn-0181
				  e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				  
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
					    
				if(con != null)
					ConnectionManager.returnConnection(con,request);

				session.setAttribute("LevelOfCareForDependency", LevelOfCareForDependency);

			  }
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
