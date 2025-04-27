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

public final class __positionformdcpdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PositionForMDCPDetail.jsp", 1709116607121L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- PositionForMDCPDetail.jsp -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\"../js/CpMessages.js\" language=\"javascript\"></script>  \n<script src=\"../../eCP/js/PositionForMDCP.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction submitPrevNext(from, to)\n{\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t\tdocument.forms[0].submit();\n}\n\nfunction selectAll(Obj,start,end)\n{\n\tif(Obj.checked)\n\t{\n\t\tfor(var i=start;i<=end;i++)\n\t\t{\n\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\teval(\"document.forms[0].chk\"+i).checked=true;\n\t\t}\n\t\tvar facility_id1 = document.forms[0].facility_id1.value;\n\t\tvar pract_type = document.forms[0].pract_type.value;\n\t\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'PositionForMDCPDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'notCleared\'><input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'\"+facility_id1+\"\'><input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\'\"+pract_type+\"\'></form></BODY></HTML>\";\n\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.frames[2].document.form1.submit();\n\t}\n\telse\t{\n\t\tfor(var i=start;i<=end;i++){\n\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\teval(\"document.forms[0].chk\"+i).checked=false;\n\t\t}\n\t\n\t\tvar HTMLVal = \"<HTML><BODY><form name=\'form1\' id=\'form1\' method=\'post\' action=\'PositionForMDCPDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'clearAll\'></form></BODY></HTML>\";\n\t\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\tparent.frames[2].document.form1.submit();\n\t}\n}\n\nfunction chkForSelectAll(start,end)\n{\n\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\')\n\t{\n\t\tdocument.forms[0].chkAll.checked=true;\n\t\tselectAll(document.forms[0].chkAll,start,end)\n\t}\n\n}\n </script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =",";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =")\' class=\'CONTENT\' >\n<form name=\'form_positionformdcpdetail\' id=\'form_positionformdcpdetail\' action=\'../../eCP/jsp/PositionForMDCPDetail.jsp\' method=\'post\' >\n\n<table  width=\'90%\' border=0 align=\'center\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n<input type=hidden name=\'facility_id1\' id=\'facility_id1\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=hidden name=\'pract_type\' id=\'pract_type\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\' text-decoration=\'none\'>Previous</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\'text-decoration=\'none\'>Next</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</td>\n</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<th width=\'60%\'><fmt:message key=\"Common.Position.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/></th>\n\t\t\t<th width=\'20%\'><fmt:message key=\"Common.selectall.label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/> <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\'></th>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" name=\'chk";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet PositionForMDCP= null;synchronized(session){
                PositionForMDCP=(webbeans.eCommon.RecordSet)pageContext.getAttribute("PositionForMDCP",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(PositionForMDCP==null){
                    PositionForMDCP=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("PositionForMDCP",PositionForMDCP,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
		
		String  req_start = "", req_end = "";
	    String  checkedOnes = "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
		String facility_id1="";
		String pract_type="";
		String flagSelect="";
		String sqlinsVals="";
		String classValue="";
		String chkAttribute="";
		String   sql  ="";
		String position_code="";
		String position_desc="";

        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start = (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
       req_end =  (request.getParameter("end")==null)   ?   "0" : request.getParameter("end");

			Statement stmt3 = null;
			ResultSet rstlRs3 = null;
			Statement stmt=null;
			PreparedStatement pstmt = null;//common-icn-0180
			PreparedStatement pstmt1 = null;//common-icn-0180
			ResultSet rs=null ;

	Connection con = null;

	try{
			
	con = ConnectionManager.getConnection(request);

	facility_id1=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	pract_type=request.getParameter("pract_type")==null?"":request.getParameter("pract_type");
	flagSelect = request.getParameter("fromSearch");

       	if(flagSelect !=null)
	        	{
	        		PositionForMDCP.clearAll();
	        		//sqlinsVals= "  select position_code from cp_position_for_mdcp where facility_id='"+facility_id1+"'";//common-icn-0180
	        		sqlinsVals= "  select position_code from cp_position_for_mdcp where facility_id= ?";//common-icn-0180
						//stmt3=con.createStatement();//common-icn-0180
						pstmt=con.prepareStatement(sqlinsVals);//common-icn-0180
						pstmt.setString(1, facility_id1);//common-icn-0180
						rstlRs3 = pstmt.executeQuery();//common-icn-0180
						//rstlRs3 = stmt3.executeQuery(sqlinsVals);//common-icn-0180
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						PositionForMDCP.putObject(rstlRs3.getString(1));

					 }
				}
	        	}
	        


             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(PositionForMDCP.containsObject(checkedOnes)))
                                 PositionForMDCP.putObject(checkedOnes);
                             j++;
                         }
                         
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
			
		 //sql  =" SELECT  position_code, position_desc, 'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = '"+facility_id1+"') AND role_type = 'P' AND ('"+pract_type+"'IS NULL OR staff_type = '"+pract_type+"') AND eff_status = 'E' UNION ALL SELECT  a.position_code,b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = '"+facility_id1+"' AND b.position_code = a.position_code AND b.role_type = 'P' AND ('"+pract_type+"'IS NULL OR staff_type = '"+pract_type+"') ORDER BY 2";//common-icn-0180
         
		 sql  =" SELECT  position_code, position_desc, 'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = ?) AND role_type = 'P' AND (? IS NULL OR staff_type = ?) AND eff_status = 'E' UNION ALL SELECT  a.position_code,b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = ? AND b.position_code = a.position_code AND b.role_type = 'P' AND (? IS NULL OR staff_type = ?) ORDER BY 2";//common-icn-0180

try{
	//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
	//common-icn-0180 starts
	pstmt1=con.prepareStatement(sql);
	pstmt1.setString(1, facility_id1);
	pstmt1.setString(2, pract_type);
	pstmt1.setString(3, pract_type);
	pstmt1.setString(4, facility_id1);
	pstmt1.setString(5, pract_type);
	pstmt1.setString(6, pract_type);
	//common-icn-0180 starts
	rs=pstmt1.executeQuery();
	//rs=stmt.executeQuery(sql);//common-icn-0180
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();

	  }catch(Exception e){
		//  out.println(e);//COMMON-ICN-0181
           e.printStackTrace();//COMMON-ICN-0181
		  }



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(start));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(end));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_id1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);

    if ( !(start <= 1)) {


            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block16Bytes, _wl_block16);

    }
    if ( !((start+10) >= maxRecord )){

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block17Bytes, _wl_block17);

    }
if(maxRecord == 0)
		
		{
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");
	}else{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(start));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(end));
            _bw.write(_wl_block21Bytes, _wl_block21);
	 
		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
			while(rs.next() && i<=end){ 
			position_code=rs.getString("position_code");
			position_desc=rs.getString("position_desc");

			if(PositionForMDCP.containsObject(position_code))  
				chkAttribute = "CHECKED";
			else
				chkAttribute="";

			int recordIndex = PositionForMDCP.indexOfObject(position_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    PositionForMDCP.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block28Bytes, _wl_block28);

			i++;
			}		
	}
			
			 }
			  catch(Exception e){out.print(e);}
			  finally
			  {
				 if(rs != null){ rs.close(); }
				 if(rstlRs3 != null){ rstlRs3.close(); }
				 if(stmt != null){ stmt.close(); }
				 if(stmt3 != null){ stmt3.close(); }
				 if(pstmt != null){ pstmt.close(); }//common-icn-0180
				 if(pstmt1 != null){ pstmt1.close(); }//common-icn-0180
					    
				if(con != null)
					ConnectionManager.returnConnection(con,request);

				session.setAttribute("PositionForMDCP", PositionForMDCP);
			  }
			  
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
