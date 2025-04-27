package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __casectiontemplatelinkingcompselscr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CASectionTemplateLinkingCompSelScr.jsp", 1709115602638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    \n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script>\n\t\tvar maxNoListComponent = 25;\n\t\tvar maxNoOtherComponent = 50;\n\t\tvar countList=0;\n\t\tvar countOther=0;\n\t\tfunction loadValues()\n\t\t{\n\t\t\tcountList=eval(document.forms[0].countList.value);\n\t\t\tcountOther=eval(document.forms[0].countOther.value);\t\t\t\n\t\t}\n\t\tfunction checkDependency(obj,index)\n\t\t{\n\t\t\tif(obj.checked)\n\t\t\t{\n\t\t\t\tif((countOther+countList)==maxNoOtherComponent)\n\t\t\t\t{\n\t\t\t\t\tvar msg =alert(getMessage(\"CANNOT_ASSIGN_ALL_COL\",\"CA\"));\n\t\t\t\t\tmsg = msg.replace(\'$$\',maxNoOtherComponent);\n\t\t\t\t\talert(msg);\n\t\t\t\t\t//alert(\"Can\'t assign More than \"+maxNoOtherComponent+\" Components\");\n\t\t\t\t\tobj.checked = false;\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t\tif(eval(\"document.forms[0].compType\"+index+\".value\")==\"L\")\n\t\t\t\t{\n\t\t\t\t\tif(countList==maxNoListComponent)\n\t\t\t\t\t{   \n\t\t\t\t\t\tvar msg =alert(getMessage(\"CANNOT_ASSIGN_ALL_LIST\",\"CA\")); \n\t\t\t\t\t\tmsg = msg.replace(\'$$\',maxNoListComponent);\n\t\t\t\t\t\talert(msg);\n\n\t\t\t\t\t\t//alert(\"Can\'t assign More than \"+maxNoListComponent+\" List Components\");\n\t\t\t\t\t\tobj.checked = false;\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\n\t\t\t\t\tcountList++;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tcountOther++;\n\t\t\t\t}\n\t\t\t\t//**********************************************************/\n\t\t\t\t//code for checkng the already assiged dependency\n\t\t\t\tif(eval(\"document.forms[0].existing\"+index+\".value\")!=\"Y\")\n\t\t\t\t{\n\t\t\t\t\tvar selectedCompIdSrlNo = eval(\"document.forms[0].selectedCompIdSrlNo\"+index+\".value\");\n\t\t\t\t\tparent.dummyFrame.location.href= \"CASectionTemplateLinkingCompSelScrCheckDependency.jsp?selectedCompIdSrlNo=C_\"+selectedCompIdSrlNo+\"&index=\"+index;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t//********************************************************/\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tobj.value = \"N\";\n\t\t\t\tif(eval(\"document.forms[0].compType\"+index+\".value\")==\"L\")\n\t\t\t\t{\n\t\t\t\t\tcountList--;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tcountOther--;\n\t\t\t\t}\n\t\t\t\teval(\"document.forms[0].existing\"+index+\".value=\'Y\'\");\n\t\t\t}\n\t\t}\n\t</script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n</head>\n<body onload=\"loadValues()\" onKeyDown=\"lockKey()\">\n<form name=compSelectionForm action=\"CASectionTemplateLinkingMain.jsp\" method=post >\n\t<table width=\'100%\' class=\'grid\' >\n\t<tr>\n\t\t<td class=\'columnheadercenter\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'columnheadercenter\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td class=\'columnheadercenter\' >&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<input type=hidden name=\"compType";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"compType";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><input type=checkbox value=\"Y\" name=\"check";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"check";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onclick=\"checkDependency(this,";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><input type=hidden name=\"selectedCompIdSrlNo";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"selectedCompIdSrlNo";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><input type=hidden name=\"selectedCompId";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"selectedCompId";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"><input type=hidden name=\"existing";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"existing";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value=\"\"></td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</table>\n\t<input type=hidden name=count value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=hidden name=comp_id value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=hidden name=comp_type value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=hidden name=section_hdg_code value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=hidden name=comp_prompt value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=hidden name=srl_no value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=hidden name=countList value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=hidden name=countOther value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);

            _bw.write(_wl_block5Bytes, _wl_block5);
  
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String compType=request.getParameter("comp_type")==null?"":request.getParameter("comp_type");
	String compPrompt=request.getParameter("comp_prompt")==null?"":request.getParameter("comp_prompt");
	String sectionHdgCode= request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code");	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	int rowNo=0;
	int countList=0,countOther=0;
	//get the dependent component from the bean for this component 
	Vector dependentComp  = templateBean.getAssociatedComponents(compId+srlNo);

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		try
		{
			String currentCompId = "";
			String currentCompPrompt = "";
			String currentCompType = "";
			String currentCompTypeDesc = "";
			String classValue = "";
			String currentCompIdSrlNo = "";
			int currentSrlNo = -1;
			String checked = "";
			con = ConnectionManager.getConnection(request);
			String sql = "select comp_id ,comp_prompt,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_desc,comp_type, srl_no from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id != ? and comp_type not in ('A','P','R','X','M') and accept_option in ('O','D') and nvl(LIST_PRESENTATION,'S')!='M' order by row_pos_no,column_pos_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sectionHdgCode);
			pstmt.setString(2, compId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				rowNo++;
				/*if(rowNo%2!=0)
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";*/
					classValue = "gridData";

				currentCompId  = rs.getString(1);
				currentCompPrompt  = rs.getString(2);
				currentCompTypeDesc  = rs.getString(3);
				currentCompType = rs.getString(4);
				currentSrlNo = rs.getInt(5);
				currentCompIdSrlNo = currentCompId+currentSrlNo;
				//verify the values in the bean with the values comming from the table for selection
				if(dependentComp!=null)
				{
					if(dependentComp.contains(currentCompIdSrlNo))
					{
						checked = "checked";
						//for getting the count o how many r already linked
						if(currentCompType.equals("L"))
							countList++;
						else
							countOther++;
					}
				}
							
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(currentCompPrompt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(currentCompTypeDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currentCompType));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currentCompIdSrlNo));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currentCompId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rowNo-1));
            _bw.write(_wl_block28Bytes, _wl_block28);

				checked = "";
			 }
			
		}
		catch(Exception e)
		{
		//	out.println(e);//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
			
		}
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(compId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(compType));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sectionHdgCode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(compPrompt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(countList));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(countOther));
            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ComponentType.label", java.lang.String .class,"key"));
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
}
