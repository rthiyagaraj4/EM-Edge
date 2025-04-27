package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHSelectQuery;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __filterandschdulingsearch2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/Filterandschdulingsearch2.jsp", 1742465826927L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML> \n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"JavaScript\" src=\'../../eCommon/js/common.js\'> </Script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n<script src=\'../../eXH/js/filterlayerrefrence.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eXH/js/filterlayerrefrenceApplication.js\' language=\'javascript\'></script>\n<script Language=\"JavaScript\" >\nvar arr=new Array();\nvar arr2=new Array();\nvar arr3=new Array();\nvar arr4=new Array();\nfunction checkfun(cou1)\n{\n\tvar len=(document.forms[0].count_fields.value);\n\t   for(var i=1;i<len;i++)\n\t{\nvar obj2=\"Element_code_Query\"+i;\nvar obj3=\"Element_code_Querys\"+i+i;\nvar anotherobj1=\"Element_code_Query\"+cou1;\n        anotherobj12=\"Element_code_Querys\"+cou1+cou1;\n var Str3=\"\";\n\t\t var Str4de=\"\";\n        if(document.getElementById(obj3).value==\'\')\n\t\t{\n\t\tdocument.getElementById(anotherobj1).value=\'\';\n         document.getElementById(anotherobj12).value=\'\';\n\t\t}\n\t\telse\n\t\t{\n           // document.getElementById(obj3).value=\'\';\n            // document.getElementById(obj2).value=\'\';\n         \n\n\n\t\t  if(document.getElementById(anotherobj1).name==document.getElementById(obj2).name)\n            {\n         document.getElementById(anotherobj1).value=\'\';\n         document.getElementById(anotherobj12).value=\'\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n          \n\t\t\t}\n               \n\t\t} \n\n\t}\n\n}\n\nfunction testfun(cou)\n{\n\t \n\tvar len=(document.forms[0].count_fields.value)\n    for(var i=1;i<len;i++)\n\t{\n\t\tobj=i+\"Filter_element_desc\";\n\t\tobj1=i+\"Filter_subtype_desc_combo\";\n\t\tobj2=\"Element_code_Query\"+i;\n\t\tobj3=\"Element_code_Querys\"+i+i;\n\t\tanotherobj=\"Element_code_Query\"+cou;\n        anotherobj2=\"Element_code_Querys\"+cou+cou;\n\t\n\t\tvar str=\"\"; \n\t\tvar Str2=\"\";\n\t\tif(document.getElementById(obj).value==\'\')\n\t\t{\n\t\t   str=\"|\";\n\t\t}\n\t\telse\n\t\t{\n           str=document.getElementById(obj).value;\n\t\t}\n        var Str2=\"\";\n\t\tif(document.getElementById(obj1).value==\'\')\n\t\t{\n\t\t   str2=\"|\";\n\t\t}\n\t\telse\n\t\t{\n           str2=document.getElementById(obj1).value;\n\t\t}\n         \n\t\t var Str3=\"\";\n\t\t var Str4de=\"\";\n        if(document.getElementById(obj3).value==\'\')\n\t\t{\n\t\t   str3=\"|\";\n\t\t   Str4de=\"|\";\n\t\t}\n\t\telse\n\t\t{\n           // document.getElementById(obj3).value=\'\';\n            // document.getElementById(obj2).value=\'\';\n         \n\n\n\t\t  if(document.getElementById(anotherobj).name==document.getElementById(obj2).name)\n            {\n            str3=\"|\";\n            Str4de=\"|\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n           str3=document.getElementById(obj3).value;\n\t\t  Str4de=document.getElementById(obj2).value;\n\t\t\t}\n\n\t\t} \n\n          arr2[i-1]=str2;\n          arr3[i-1]=Str4de;\n           arr4[i-1]=str3;\n\n          arr[i-1]=str;\n\n\n\n\n\n\n\t}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' >\n<form name=\"FilterSearchForm\" id=\"FilterSearchForm\" target=\'messageFrame\' action=\'../../eXH/jsp/FilterAndSchedulingUpdateRecord.jsp\'>\n\n\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n <tr>\n  \n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </td>\n\t\t<td class=\'fields\'><select  name=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' id=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onChange=\"testfun(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');location.href=\'../../eXH/jsp/Filterandschdulingsearch2.jsp?Filter_group_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&selectcount=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&flag=5&qryString=\'+arr+\'&qryString2=\'+arr2+\'&qryString3=\'+arr3+\'&qryString4=\'+arr4+\'&levelcount=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Transnumber=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\">\n\t\t<option value=\"\">   ----";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="----    </option>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t\t  <option value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" selected>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n  \t\t <option value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</select></td>\n\t<td class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n\t<td class=\'fields\'><select name=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  onChange=\"checkfun(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\" >\n\t<option value=\"\">   ----";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<option value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</select></td>\n\t\t<td class=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t<td align=left>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\n\t\t\n\t\t<input type=\"text\" name =\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=\'15\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  >\n\t\t<input class=\'button\' type=\"button\"  name=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\'?\'   onClick=\"myClick(event,";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =")\"><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t<input type=\"hidden\" name=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=\"hidden\" name=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type=\"hidden\" name=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'> \n\t\t</td> \n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n</tr>\n</table>\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t\t<td class=\"BUTTON\" colspan=\"5\"><input class=\'button\' type=\'button\'  name=\'Record\' id=\'Record\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' onClick=\"recordU()\">\n\t\t<input class=\'button\' type=\'button\'  name=\'delete\' id=\'delete\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onClick=\'delete1();\'>\n\t\t</td>\n\t\t<input type=hidden name=Tranaction_number id=Tranaction_number value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=hidden name=count_fields id=count_fields value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=hidden name=Filter_group_desc_id id=Filter_group_desc_id value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=hidden name=count id=count value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' >\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n</tr>\n<tr>\n     <td colspan=3></td>\n</tr>\n</table>\n<input type=hidden name=actualmode id=actualmode value=\'\'>\n<input type=hidden name=element_field id=element_field value=\'\'>\n<input type=hidden name=element_field id=element_field value=\'\'>\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


			String selectedStr="";String selectedStr2="";String selectedStr3="";String selectedStr4="";
			int c=1;
			String Filter_type_code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
			String tranaction_number=XHDBAdapter.checkNull(request.getParameter("Transnumber"));
			String levelcount1=XHDBAdapter.checkNull(request.getParameter("levelcount")); 

			//System.out.println("levelcount1"+levelcount1);
			String [] Filterleveltype=new String[Integer.parseInt(levelcount1)];
			String [] Filterlevelsubtype=new String[Integer.parseInt(levelcount1)];	
			String [] Filterlevelcode=new String[Integer.parseInt(levelcount1)];
			String [] Filterlevelvalue=new String[Integer.parseInt(levelcount1)];
			for(int k=0;k<Integer.parseInt(levelcount1);k++)
			{
				Filterleveltype[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_type"));
				Filterlevelsubtype[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_subtype"));
				Filterlevelcode[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_code"));
				Filterlevelvalue[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_value"));
				c++;
			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			int sel=0;int sel2=0;int sel3=0;
			String flag="0";
			int i=0;
			int levelcount=0;
			ResultSet resultset = null;
			PreparedStatement pstmt = null ;
			String Defval="";String Defval2="";String Defval3="";String Defval4="";

			Statement stment=null;
			Connection conn = null;
			ResultSet rset = null;
			//System.out.println("levelcount1");
				int j=1;


	try
	{
		if(conn==null) conn = ConnectionManager.getConnection();
	}
	catch(Exception exp)
	{
		 System.out.println("Error in calling getconnection method of Filterandschdulingsearch2.jsp  :"+exp.toString());
	     exp.printStackTrace(System.err);
	}
   try
   {
		 stment= conn.createStatement();
		 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+Filter_type_code+"'");
		 resultset.next();
		 levelcount = resultset.getInt("rowcount") ;
		 resultset.close() ;
		 stment.close();
		 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+Filter_type_code+"' ORDER BY 1";
		 pstmt = conn.prepareStatement(sql);
		 rset = pstmt.executeQuery();
		 while(rset.next())
		 {
			 selectedStr="";
			 String querys=rset.getString(4);
  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rset.getString(5)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(j+"Filter_element_desc"));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j+"Filter_element_desc"));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(j));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Filter_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(levelcount1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tranaction_number));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		String sql1=rset.getString(2);	
		PreparedStatement pstatement1 = null ;
		ResultSet resultset1 = null;
		try 
		 {
		    flag=XHDBAdapter.checkNull(request.getParameter("flag"));

	    	if(flag.equals("5"))
    		{

				Defval= request.getParameter("qryString");
				String[] values=Defval.split(",");
				if(values[sel].equals("|") )
				{
					selectedStr=" ";
				}
				else
				{
			        selectedStr=values[sel]; 
				}
				sel++;
           // String selcou=request.getParameter("selectcount");

           }
	       else
		   {
				selectedStr=Filterleveltype[i];
		   }
  			 pstatement1 = conn.prepareStatement(sql1);
			 resultset1 = pstatement1.executeQuery();
			 while(resultset1.next())
			 {
			     if(selectedStr.equals(resultset1.getString(2)))
				 {

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selectedStr));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(resultset1.getString(1)));
            _bw.write(_wl_block20Bytes, _wl_block20);

		         }
				 else
				 {
	 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(resultset1.getString(2)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(resultset1.getString(1)));
            _bw.write(_wl_block20Bytes, _wl_block20);

		         } 
			 }
	    }
	 catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of Filterandschdulingsearch2.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
		}
     finally
	 {
		pstatement1.close();
    	resultset1.close() ;
	 }
	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rset.getString(6)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j+"Filter_subtype_desc_combo"));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j+"Filter_subtype_desc_combo"));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	String answer2=Filterlevelsubtype[i];

            _bw.write(_wl_block2Bytes, _wl_block2);


	String reSecond = new String("'"+selectedStr+"'");
	String sql2="";
	if(rset.getString(3).indexOf(":1")!=-1)
		{
	        sql2=rset.getString(3).replace(":1",reSecond);
		} 
		else
		{
			sql2=rset.getString(3);
		}
		  PreparedStatement pstatement2 = null ;
	      ResultSet resultset2 = null;
try
	 {

	            selectedStr2=answer2;
               if(flag.equals("5"))
			   {
        		   Defval2= request.getParameter("qryString2");
					String[] values2=Defval2.split(",");
					if(values2[sel2].equals("|") )
					{
						selectedStr2=" ";
					}
					else
					{
					    selectedStr2=values2[sel2];
					}

					sel2++;
					//String selcou=request.getParameter("selectcount");
               }
			pstatement2 = conn.prepareStatement(sql2);
			resultset2 = pstatement2.executeQuery();
		 while(resultset2.next())
		 {
			if(selectedStr2.equals(resultset2.getString(2)))
		      { 

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(selectedStr2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(resultset2.getString(1)));
            _bw.write(_wl_block20Bytes, _wl_block20);

		      }
		      else
		     { 
	 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resultset2.getString(2)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(resultset2.getString(1)));
            _bw.write(_wl_block20Bytes, _wl_block20);

    		 }
        }
	  }
	 catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of Filterandschdulingsearch2.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
 	 finally
	 {
    pstatement2.close();
	resultset2.close() ;
	
	 }
	
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rset.getString(7)));
            _bw.write(_wl_block30Bytes, _wl_block30);

         selectedStr3=Filterlevelcode[i];
	     selectedStr4=Filterlevelvalue[i];
	 	if(flag.equals("5"))
			   {
			selectedStr3="";
	     selectedStr4="";
        		   Defval3= request.getParameter("qryString3");
					String[] values3=Defval3.split(",");
					if(values3[sel3].equals("|") )
					{
						selectedStr3=" ";
					}
					else
					{
					    selectedStr3=values3[sel3];
					}
                    Defval4= request.getParameter("qryString4");
					String[] values4=Defval4.split(",");
					if(values4[sel3].equals("|") )
					{
						selectedStr4=" ";
					}
					else
					{
					    selectedStr4=values3[sel3];
					}  



					sel3++;
					//String selcou=request.getParameter("selectcount");
               }  
	  
	     
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf("Element_code_Query"+j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(selectedStr3));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j+"Element_code_Query_idb"));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j+"Element_code_Query_idb"));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf("Element_code_Querys"+j+j));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf("Element_code_Querys"+j+j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(selectedStr4));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j+"Element_code_Query_id"));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j+"Element_code_Query_id"));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(querys));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j+"leval_number"));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j+"leval_number"));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block40Bytes, _wl_block40);

	j++;
	 i++;
	 }
 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tranaction_number));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(Filter_type_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(levelcount1));
            _bw.write(_wl_block47Bytes, _wl_block47);

}
catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of Filterandschdulingsearch2.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}finally
	{
    	if(rset!=null)
		{
			rset.close() ;
            pstmt.close();
		}
		if(conn!=null)
		ConnectionManager.returnConnection(conn);
	}

            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.record.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
}
