package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifyclinicservice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/AddModifyClinicService.jsp", 1720585784607L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!-- Program for to display services for the clinic -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n<head>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../js/ClinicService.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n       \n/*\t\n  This function is used for Next and Previous Buttons.\t\n*/\t\n\tfunction submitPrevNext(from, to,ccode,ctype,cind){\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t\tdocument.forms[0].submit();\n\t}\n\n</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n              <input type=hidden name=\'pages\' id=\'pages\' value=\'multiple\'>\n\t\t\t  <input type=hidden name=\'totChecked\' id=\'totChecked\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<body  OnMouseDown=\"CodeArrest();\"  class=\'CONTENT\' onKeyDown = \'lockKey();\'>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eOP/jsp/AddModifyClinicService.jsp\' method=\'post\' >\n<p>\n<table align=\'right\'>\n<tr>\n<td>\n<input type=hidden name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\n<input type=hidden name=\'clinic_type\' id=\'clinic_type\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\n<input type=hidden name=\'care_indicator\' id=\'care_indicator\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<input type=hidden name=\'dept_code\' id=\'dept_code\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=\'hidden\' name=\'care_ind\' id=\'care_ind\' value=\'\'>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =",";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n    <a id=\'nextval\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</td>\n</tr>\n</table>\t\n<br><br>\n</P>\n\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t<th class=\'columnheader\' align=\'center\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t\t\t\t<th class=\'columnheader\' align=\'center\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="  name=\'chk";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' > <input type=\'hidden\' value= \'\' name=\'no_of_beds";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'no_of_beds";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'></td>\n\t\t\t</tr>\n\t\t\t\t\t<input type=\'hidden\' name=\'recordCount\' id=\'recordCount\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\n\t\t\t\t\t<input type=\'hidden\' name=\'deptCode";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'deptCode";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'room_num";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'room_num";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'finalval\' id=\'finalval\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'dept_code_next\' id=\'dept_code_next\' value=\'\'>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'COMMON\'));\n\t\t\t\t//parent.frames[0].document.forms[0].submit();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<input type=\'hidden\' name=\'sCnt\' id=\'sCnt\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"nextval\").innerHTML=\" \";\n\t\t\t\t\t//document.getElementById(\"nextval\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet accessRightRecSet_two= null;synchronized(session){
                accessRightRecSet_two=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet_two",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet_two==null){
                    accessRightRecSet_two=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet_two",accessRightRecSet_two,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


/*
   Get the Information from the JSP page using getParameters.Based on the 
   values retrieve the Resultset from the database and display 10 records
   per page. Here  used one Bean class "RecordSet".
*/
		
		String  req_start   =   "", req_end     =   "";
	    String  checkedOnes         =   "";
		 String  checkedDeptOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
			
        //int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
		int i=1;
		int endOfRes = 1;
		
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
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

	
	String facility_id=(String)session.getValue("facility_id");
	String clinic_code=request.getParameter("clinic_code");
	String clinic_type=request.getParameter("clinic_type");
	String care_indicator=request.getParameter("care_indicator");
	String dept_code=checkForNull(request.getParameter("dept_code"));
	String dept_desc="";
	String dept_code1="";

	String flagSelect = request.getParameter("fromSelect");
	 String sqlinsVals="";
	 String removeCode="";
	/*
		To display the service for a particular clinic, use the 
		the query -This query fetches the service Code from the table op_clinic_for_service
  	based on clinic_code and dept_code and facility_id
	 *///added condition check clinic_type,CARE_LOCN_TYPE_IND by rajesh 19/10/2004 
	if(flagSelect !=null)
		{
	  		accessRightRecSet.clearAll();
			accessRightRecSet_two.clearAll();
			if(!dept_code.equals(""))
			{
	  	     sqlinsVals= " select SERVICE_CODE,DEPT_CODE  from OP_CLINIC_FOR_SERVICE where clinic_code='"+clinic_code+"' and dept_code= '"+dept_code+"' and clinic_type = '"+clinic_type+"'and CARE_LOCN_TYPE_IND = '"+care_indicator+"'and FACILITY_ID='"+facility_id+"' order by 1";
			}else
			{
			  sqlinsVals= " select SERVICE_CODE,DEPT_CODE  from OP_CLINIC_FOR_SERVICE where clinic_code='"+clinic_code+"' and clinic_type = '"+clinic_type+"'and CARE_LOCN_TYPE_IND = '"+care_indicator+"'and FACILITY_ID='"+facility_id+"' order by 1";
			}

			stmt3=con.createStatement();
			rstlRs3 = stmt3.executeQuery(sqlinsVals);
			
			if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						accessRightRecSet.putObject(rstlRs3.getString(1));
						accessRightRecSet_two.putObject(rstlRs3.getString(2));
						
					 }
				}



				if(rstlRs3 != null) rstlRs3.close();
				if(stmt3 != null )stmt3.close();

	        	}
	 	        int recordCount			=	0;

			if(from != null && to != null)
             {
                     int j=0;
					for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
							 checkedDeptOnes=request.getParameter("deptCode"+(i));

                             if(!(accessRightRecSet.containsObject(checkedOnes)))
							 {
                                 accessRightRecSet.putObject(checkedOnes);
							   accessRightRecSet_two.putObject(checkedDeptOnes);
							 }
                             j++;
                         }
						 removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclCode = request.getParameter("spclCode"+(i));

							if((accessRightRecSet.containsObject(spclCode)))
							{
								int removeCodeIndex = accessRightRecSet.indexOfObject(spclCode);
								accessRightRecSet.removeObject(removeCodeIndex);
								accessRightRecSet_two.removeObject(removeCodeIndex);
							}
						}
                      }
			     
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j));
            _bw.write(_wl_block11Bytes, _wl_block11);

			 }
           	i = 1 ;
     		String classValue="QRYODD";
			String chkAttribute="";

			StringBuffer sql=new StringBuffer();
			sql.append("SELECT A.service_code, c.short_desc short_desc, a.DEPT_SHORT_DESC dept_desc,a.dept_code dept_code,'Y' FROM op_clinic_for_service_vw a, am_facility_service b, am_service c WHERE a.facility_id = b.operating_facility_id AND a.dept_code = b.dept_code and  A.facility_id='"+facility_id+"'AND A.CARE_LOCN_TYPE_IND='"+care_indicator+"'AND A.clinic_type='"+clinic_type+"'");
				if(!dept_code.equals(""))
				sql.append("AND B.dept_code = nvl('"+dept_code+"',b.dept_code)");
				
			sql.append(" AND B.service_code = C.service_code  AND clinic_code='"+clinic_code+"' AND A.service_code=b.service_code AND B.eff_status='E' AND A.service_code not in (select service_code from op_Clinic  Where clinic_code='"+clinic_code+"') UNION SELECT A.service_code, a.SERVICE_SHORT_DESC short_desc ,a.DEPT_SHORT_DESC dept_desc,a.dept_code dept_code, 'N' FROM am_facility_service_vw a  WHERE ");
			sql.append("  operating_facility_id = '"+facility_id+"' "); 
			if(!dept_code.equals(""))
			sql.append("AND A.dept_code =nvl('"+dept_code+"',a.dept_code)");
			
			sql.append(" and A.service_code NOT IN ( SELECT service_code  FROM OP_CLINIC_FOR_SERVICE  WHERE facility_id='"+facility_id+"'AND CARE_LOCN_TYPE_IND='"+care_indicator+"'AND clinic_type='"+clinic_type+"' ");
				if(!dept_code.equals(""))
				sql.append("AND dept_code = nvl('"+dept_code+"',dept_code)");
				sql.append("AND clinic_code='"+clinic_code+"') and A.service_code not in (select service_code from op_Clinic Where clinic_code='"+clinic_code+"') AND A.eff_status='E' ORDER BY 2 ");
	 try{
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql.toString());
	 }catch(Exception e){out.println(e);}

	 if (start != 0)
		for(int j=1; j<=start; i++,j++)			
				rs.next() ;


            _bw.write(_wl_block12Bytes, _wl_block12);
 int sCnt=0; while( i<=end && rs.next()) { if (sCnt == 0) {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(care_indicator));
            _bw.write(_wl_block16Bytes, _wl_block16);

	if(!dept_code.equals(""))
	{	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dept_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(start));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(end));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(start));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(end));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

    if ( !(start <= 1)) {

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

    }
    if ( endOfRes == 1) {

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

    }

            _bw.write(_wl_block31Bytes, _wl_block31);
	

		recordCount =	accessRightRecSet.getSize();	

			
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
}

			String short_desc=rs.getString("short_desc");
			dept_desc=rs.getString("dept_desc");
			dept_code1 =rs.getString("dept_code");
			String room_num=  rs.getString("service_code");

			if(accessRightRecSet.containsObject(room_num))
					chkAttribute = "CHECKED";
				else
					chkAttribute="";


				int recordIndex = accessRightRecSet.indexOfObject(room_num);	
				if(recordIndex!=-1)
				{
					if(chkAttribute.equals("CHECKED"))  
					{
						accessRightRecSet.removeObject(recordIndex); 
						accessRightRecSet_two.removeObject(recordIndex); 
					}
					
				}
				if( classValue.equals("QRYODD")) 
					classValue="QRYEVEN";
				else	
					classValue="QRYODD";
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dept_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dept_code1));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
			
				i++;
				sCnt++;				
			
			}
			if(sCnt == 0)
			{
            _bw.write(_wl_block52Bytes, _wl_block52);
}

			if(sCnt>0) { 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sCnt));
            _bw.write(_wl_block54Bytes, _wl_block54);
}

			if (!rs.next() && sCnt!=0 )
			{
				endOfRes = 0;	
				
            _bw.write(_wl_block55Bytes, _wl_block55);

			 }
		
		 if(rs !=null )rs.close();
    	  if(stmt != null )stmt.close();
		  
		}
		catch(Exception e){out.print(e);}
		finally
		{
		     try{
			 if(stmt != null){ stmt.close(); }
		     if(rs != null){ rs=null;}
		     if(stmt3 != null){ stmt3 .close();}
			 if(rstlRs3 != null){ rstlRs3 = null;} 
			 }catch(Exception e){}
			if(con != null) ConnectionManager.returnConnection(con,request);
			session.setAttribute("ClinicService", accessRightRecSet);
			session.setAttribute("ClinicDeptService", accessRightRecSet_two);
		}
		
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.department.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
