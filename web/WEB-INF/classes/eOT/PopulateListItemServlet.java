/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;

public class PopulateListItemServlet extends javax.servlet.http.HttpServlet{
public void init(ServletConfig config) throws ServletException{
	super.init(config);
}

public void doPost(HttpServletRequest request, HttpServletResponse res)
throws javax.servlet.ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends
		
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		String flag = CommonBean.checkForNull(request.getParameter("flag"));
		String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
		String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
		java.util.Properties prop = (java.util.Properties) session.getAttribute("jdbc");
		String locale = prop.getProperty("LOCALE");
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rst = null;
		
		StringBuffer codebuffer = new StringBuffer();
		StringBuffer descbuffer = new StringBuffer();
		PrintWriter out=res.getWriter();
		
		String code = "";
		String desc = "";
		int fetchCount=0;
		try{
	//SKR-SCF-0853 044346 change done	
		/*	if(flag.equals("AS")||flag.length()==0)
			{
				codebuffer.append("*ALL");//code
				descbuffer.append("All Specialities");//desc
				++fetchCount;
			} else	*/ 
	if(flag.equals("IS")||flag.length()==0){	
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT1")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();	 
			while(rst.next()){
				++fetchCount;
				if(fetchCount==1){
					codebuffer.append(rst.getString(1));//code
					descbuffer.append(rst.getString(2));//desc
				}else{
				   codebuffer.append(","+rst.getString(1));//code
				   descbuffer.append(","+rst.getString(2));//desc
				}
			}//end of while
			code = codebuffer.toString();
			desc = descbuffer.toString();
			out.println("assignListItems('"+code+"','"+desc+"')");
		//SKR-SCF-0853 044346 change done
			} else if(flag.equals("AS")||flag.length()==0){			
			out.println("assignListItems('*ALL','All Specialities')");			 
			} 
	}catch(Exception e){
		System.err.println("PopulateListItem.jsp"+e.getMessage());
	}
	finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			if(codebuffer!=null) codebuffer.setLength(0);
			if(descbuffer!=null) descbuffer.setLength(0);
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
 }//do Post End here
}//servlet Ends Here
