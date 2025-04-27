<!DOCTYPE html>
<!--
----------------------------------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
----------------------------------------------------------------------------------------------------------------------------------------
11-May-2016    100           	Karthikeyan.K       MMS-CRF-003 Karthik Created this File code for Package Subscription and Association
----------------------------------------------------------------------------------------------------------------------------------------
-->

<%@page  import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.*,eBL.PkgAssociationExistingPackagesBean" contentType="text/html;charset=ISO-8859-1" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<HTML>


<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String operation=request.getParameter("operation");
	
	if(operation.equals("add")){
		
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList= (session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>(): (ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");	
		PkgAssociationExistingPackagesBean beanObj=new PkgAssociationExistingPackagesBean();
	 	String existingPkgCode=request.getParameter("existingPkgCode");
		String existingPkgSeqNo=request.getParameter("existingPkgSeqNo");
		String existingPkgEpiType=request.getParameter("existingPkgEpiType");
		String existingPkgFrmDte=request.getParameter("existingPkgFrmDte");
		//System.out.println("existingPkgFrmDte in persistence"+existingPkgFrmDte);
		//System.out.println("existingPkgCode in persistence"+existingPkgCode);
		String existingPkgBlngClassCode=request.getParameter("existingPkgBlngClassCode");
		
		beanObj.setExistingPkgCode(existingPkgCode);
		beanObj.setExistingPkgSeqNo(existingPkgSeqNo);
		beanObj.setExistingPkgEpiType(existingPkgEpiType);
		beanObj.setExistingPkgFrmDte(existingPkgFrmDte);
		beanObj.setExistingPkgBlngClassCode(existingPkgBlngClassCode);
		pkgAssociationExistingPackagesBeanList.add(beanObj);
		session.setAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG", pkgAssociationExistingPackagesBeanList );
		//System.out.println(pkgAssociationExistingPackagesBeanList);
		
	}
	else if(operation.equals("remove")){
	
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList= (session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>(): (ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanListTemp=pkgAssociationExistingPackagesBeanList;
		String existingPkgSeqNo=request.getParameter("existingPkgSeqNo");
		for(int i=0;i<pkgAssociationExistingPackagesBeanList.size();i++){
			PkgAssociationExistingPackagesBean beanObj=pkgAssociationExistingPackagesBeanList.get(i);
			if(beanObj.getExistingPkgSeqNo().equals(existingPkgSeqNo)){				
				pkgAssociationExistingPackagesBeanListTemp.remove(i);
				break;
			}
		}
		session.setAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG", pkgAssociationExistingPackagesBeanListTemp );
		System.out.println(pkgAssociationExistingPackagesBeanList);
		
	}
	
	
	else if(operation.equals("modify"))
	{
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList=(session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>():(ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanListModify=pkgAssociationExistingPackagesBeanList;
		String existingPkgSeqNo=request.getParameter("existingPkgSeqNo");
		String existingPkgCode=request.getParameter("existingPkgCode");
		String existingPkgEpiType=request.getParameter("existingPkgEpiType");
		String existingPkgFrmDte=request.getParameter("existingPkgFrmDte");
		PkgAssociationExistingPackagesBean beanObj=null;
		/*System.out.println("existingPkgFrmDte in persistence"+existingPkgFrmDte);
		System.out.println("existingPkgCode in persistence"+existingPkgCode);
		System.out.println("existingpkgseqbo "+existingPkgSeqNo);
		System.out.println("existingPkgEpiType "+existingPkgEpiType);*/
		
		
		for(int i=0;i<pkgAssociationExistingPackagesBeanList.size();i++)
		{
			 beanObj=pkgAssociationExistingPackagesBeanList.get(i);
			if(beanObj.getExistingPkgSeqNo().equals(existingPkgSeqNo)){
				pkgAssociationExistingPackagesBeanListModify.remove(i);	
				beanObj.setExistingPkgCode(existingPkgCode);
				beanObj.setExistingPkgSeqNo(existingPkgSeqNo);
				beanObj.setExistingPkgEpiType(existingPkgEpiType);
				beanObj.setExistingPkgFrmDte(existingPkgFrmDte);
				break;
			}
		}
		pkgAssociationExistingPackagesBeanListModify.add(beanObj);
		System.out.println("List in Modify "+pkgAssociationExistingPackagesBeanListModify);
		session.setAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG", pkgAssociationExistingPackagesBeanListModify);
		
		
	}
	
	
	
	else{
	session.removeAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
	session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
	//System.out.println("session BL_CREDIT_CARD_DETAILS cleared");
	}
	
	

	

%>

</HTML>
