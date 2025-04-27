package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __validatecell extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ValidateCell.jsp", 1709116420323L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<html>\n\t<head> \n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/ChartHistoryTemplate.js\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t</head>\n\t\t\n\t<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t\t<form name=\"Temp_form\" id=\"Temp_form\" action=\"../../servlet/eCA.ChartHistoryTemplateServlet\" target=\"messageFrame\" method =\"post\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar msg=getMessage(\"WRONG_ROW_COLUMN_VALUES\",\'CA\');\n\t\t\t\t\t\t\t\tif (msg!=\"\"){\n\t\t\t\t\t\t\t\t\t\tparent.parent.frames[2].messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\teval(\"parent.frames[1].frames[1].document.forms[0].row_pos\"+";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="+\".focus()\");\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg=getMessage(\"WRONG_ROW_COLUMN_VALUES\",\'CA\');\n\t\t\t\t\t\t\t\t\tif (msg!=\"\"){\n\t\t\t\t\t\t\t\t\t\tparent.parent.frames[2].messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\teval(\"parent.frames[1].frames[1].document.forms[0].row_pos\"+";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="+\".focus()\");\n\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg=getMessage(\"VAL_NOT_BLANK\",\'CA\');\n\t\t\t\t\t\t\t\t\tif (msg!=\"\"){\n\t\t\t\t\t\t\t\t\t\t\tparent.parent.frames[2].messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\teval(\"parent.frames[1].frames[1].document.forms[0].row_pos\"+";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="+\".focus()\");\n\t\t\t\t\t\t\t</script>\n\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n             <script>\n\t\t\t\t\tif(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].summarydesc.value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].submit();\n\t\t\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</script> \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
 int maxrow=0; 
 int maxcolumn=0; 
 boolean print=true; 
 boolean value=false; 
 boolean submitvalue=false; 
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet SubSecRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("SubSecRecordSet","webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet SubSecondRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("SubSecondRecordSet","webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet FinalBean = (webbeans.eCommon.RecordSet)getObjectFromBean("FinalBean","webbeans.eCommon.RecordSet",session);

            _bw.write(_wl_block7Bytes, _wl_block7);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

			String row_pos_h ="",cols_pos_h = "",row_span_h ="",col_span_h = "",cont_id="";
			int prev_row_pos_h=0,prev_cols_pos_h=0,prev_row_span_h=0, prev_col_span_h=0;
			int  prev_cont_id_sec=0;
			int rowpos,	colpos,	rowspan ,		colspan  ;

			
			int xval = 0;
			
			StringTokenizer stoken_code_value = null,stoken_code = null;
			String sel_code_seq="";
			HashMap htRecord = null,htRecord_atl = null;
			
			//String row_pos="",row_span="",col_span="";
			
			String SelectYNStr			=	request.getParameter("SelectYNStr"); 
			
	
			if(SelectYNStr == null || SelectYNStr.equals("null"))  SelectYNStr="";
			String maxr = request.getParameter("rows"); 
			String maxc = request.getParameter("cols"); 

			String summarydesc=request.getParameter("summarydesc")==null?"":request.getParameter("summarydesc");
			String value1="";
			maxrow = (Integer.parseInt(maxr));
			maxcolumn = (Integer.parseInt(maxc));
			if(!(SelectYNStr.equals(""))){
						SubSecRecordSet.clearAll();
						stoken_code			=	new StringTokenizer(SelectYNStr,"~");
						int count_code		=	stoken_code.countTokens();
						if(SubSecRecordSet.getSize() > 0) SubSecRecordSet.clearAll();
						if(SubSecondRecordSet.getSize() > 0) SubSecondRecordSet.clearAll();
						if(FinalBean.getSize() > 0) FinalBean.clearAll(); 
						for(int i=0;i<count_code;i++){
								sel_code_seq		=	stoken_code.nextToken();
								value1 = sel_code_seq;
								stoken_code_value		=	new StringTokenizer(value1,"||");
								row_pos_h = stoken_code_value.nextToken();
								if((Integer.parseInt(row_pos_h)) == 0){ 
								}else{
									cols_pos_h = stoken_code_value.nextToken();
									row_span_h = stoken_code_value.nextToken();
									col_span_h = stoken_code_value.nextToken();
									cont_id    = stoken_code_value.nextToken();	
									htRecord = new HashMap();
									htRecord.put("row_pos",row_pos_h);
									htRecord.put("cols_pos",cols_pos_h);
									htRecord.put("row_span",row_span_h);
									htRecord.put("col_span",col_span_h);
									htRecord.put("cont_id",cont_id);
									SubSecRecordSet.putObject(htRecord);
							}	
					}
			}

		putObjectInBean("SubSecRecordSet",SubSecRecordSet,session);

		try{
			 
			
			 
			 
 			int testArray[][]=new int[maxrow][maxcolumn];
			int i1,j1;
			for( i1=0;i1<maxrow;i1++){
					for( j1=0;j1<maxcolumn;j1++){
							testArray[i1][j1]=0	;
				}
			}

			String row_pos_return, cols_pos_h_return, row_span_h_return, col_span_h_return, cont_id_sec;
			 for(int i=0; i<SubSecRecordSet.getSize(); i++){
					boolean flag=false;
					htRecord_atl   = (HashMap)SubSecRecordSet.getObject(i);
					row_pos_return		= (String)htRecord_atl.get("row_pos");
					cols_pos_h_return  = (String)htRecord_atl.get("cols_pos");  
					row_span_h_return	= (String)htRecord_atl.get("row_span");
					col_span_h_return	= (String)htRecord_atl.get("col_span"); 
					cont_id_sec				= (String)htRecord_atl.get("cont_id"); 
					prev_row_pos_h		= (Integer.parseInt(row_pos_return));
					prev_cols_pos_h		= (Integer.parseInt(cols_pos_h_return));
					prev_row_span_h	= (Integer.parseInt(row_span_h_return));
					prev_col_span_h		= (Integer.parseInt(col_span_h_return));
					prev_cont_id_sec	= (Integer.parseInt(cont_id_sec));
					rowpos      = (Integer.parseInt(row_pos_return));
					colpos     = (Integer.parseInt(cols_pos_h_return));
					rowspan    = (Integer.parseInt(row_span_h_return));
					colspan     = (Integer.parseInt(col_span_h_return));
					rowpos=rowpos-1;
					colpos=colpos-1;

					if((rowpos+rowspan)>maxrow)  flag=true;
					if((colpos+colspan)>maxcolumn) flag=true;
					if (flag){	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(xval));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
	
					for( i1=rowpos;i1<(rowpos+rowspan);i1++){
						for( j1=colpos;j1<(colpos+colspan);j1++){
								if(testArray[i1][j1]==1){
										flag=true;
										break;
								}else{
										testArray[i1][j1]=1;
								}
						}
						if (flag) break;
					}

					if (flag){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(xval));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
				
				if(!value){
							HashMap finalcount = new HashMap();
							finalcount.put("prev_row_pos_h",new Integer(prev_row_pos_h));
							finalcount.put("prev_cols_pos_h",new Integer(prev_cols_pos_h));
							finalcount.put("prev_row_span_h",new Integer(prev_row_span_h));
							finalcount.put("prev_col_span_h",new Integer(prev_col_span_h));
							finalcount.put("prev_cont_id_sec",new Integer(prev_cont_id_sec));
							FinalBean.putObject(finalcount);
							print = true;	
					}
				
				value = false;
				submitvalue = true;
			 }

			boolean flag1=false;
			/*for( i1=0;i1<maxrow;i1++){  // CHECKING for whether all the cells are filled or not.
						for( j1=0;j1<maxcolumn;j1++){
							out.println("<script language=javascript>alert("+testArray[i1][j1]+")</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


");
						}
				}*/

				for( i1=0;i1<maxrow;i1++){  // CHECKING for whether all the cells are filled or not.
						for( j1=0;j1<maxcolumn;j1++){
									if(testArray[i1][j1]==0){ 
											flag1=true;			
											break;
								}
						}
					if (flag1) break;
				}

				if (flag1){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(xval));
            _bw.write(_wl_block15Bytes, _wl_block15);
 }

			/*HashMap finalcounting = null;
			for(int i=0; i<FinalBean.getSize(); i++){
					finalcounting   = (java.util.HashMap)FinalBean.getObject(i);
					 int cols_pos_h_return_int	= ((Integer)finalcounting.get("prev_cols_pos_h")).intValue() ;
					 int row_pos_return_int    = ((Integer)finalcounting.get("prev_row_pos_h")).intValue(); 	 
					 int col_span_h_return_int	= ((Integer)finalcounting.get("prev_col_span_h")).intValue();
					 int row_span_h_return_int	= ((Integer)finalcounting.get("prev_row_span_h")).intValue(); 
					 int prev_cont_id_sec_int    = ((Integer)finalcounting.get("prev_cont_id_sec")).intValue(); 
			}*/
	
	putObjectInBean("FinalBean",FinalBean,session);

	}catch(Exception e){
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
	}finally {  
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(submitvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(summarydesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
