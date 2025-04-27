/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.setupParameter.util;


import java.util.Date;
import java.util.List;
import com.iba.ehis.dobj.LcParamForFacility;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.setupParameter.vo.SetupParameterVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class SetupParameterAssembler extends AppAssembler {
	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return convertDO2VO(dObj);
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		// TODO Auto-generated method stub
		LcParamForFacility lcParam = new LcParamForFacility();
		Date dt=null;
		SetupParameterVO setupParameterVO = (SetupParameterVO) vo;

		try {
			IBALogger.getLogger().debug(
					this.getClass(),
					"SetupParameterAssembler ------------------>convertVO2DO "
							+ setupParameterVO.getCutOffTimeForLinenDelv(),
					null);

			lcParam.setOperatingFacilityId(setupParameterVO
					.getAddedFacilityId());
			lcParam.setAddedById(setupParameterVO.getAddedById());
			lcParam.setAddedDate(setupParameterVO.getAddedDate());
			lcParam.setAddedAtWsNo(setupParameterVO.getAddedAtWsNo());
			lcParam.setAddedFacilityId(setupParameterVO.getAddedFacilityId());

			lcParam.setModifiedAtWsNo(setupParameterVO.getModifiedAtWsNo());
			lcParam.setModifiedById(setupParameterVO.getModifiedById());
			lcParam.setModifiedDate(setupParameterVO.getModifiedDate());
			lcParam.setModifiedFacilityId(setupParameterVO
					.getModifiedFacilityId());

			lcParam.setDirtyLinenEntryByLaundry(setupParameterVO
					.getDirtyLinenEntryByLaundry());
			lcParam.setConfReqdForDirtyLinen(setupParameterVO
					.getConfReqdForDirtyLinen());
			lcParam.setStdStockChk(setupParameterVO.getStdStockChk());
			} catch (Exception e)
					{	IBALogger.getLogger().debug(this.getClass(),
								"SetupParameterAssembler ----EXCEPTION---------->convertVO2DO ",null);
						e.printStackTrace();
					}
		
			if(setupParameterVO
					.getCutOffTimeForLinenDelv()!=null){
			lcParam.setCutOffTimeForLinenDelv(setupParameterVO
					.getCutOffTimeForLinenDelv());
			}
			if(setupParameterVO
					.getCutOffTimeForLinRecptFr()!=null){
			lcParam.setCutOffTimeForLinRecptFr(setupParameterVO
					.getCutOffTimeForLinRecptFr());
			}
			
			if(setupParameterVO.getCutOffTimeForLinRecpt2Fr()!=null){
		
			lcParam.setCutOffTimeForLinRecpt2Fr(setupParameterVO
					.getCutOffTimeForLinRecpt2Fr());
			}
			
			if(setupParameterVO.getCutOffTimeForLinRecpt3Fr()!=null){
		
			lcParam.setCutOffTimeForLinRecpt3Fr(setupParameterVO
					.getCutOffTimeForLinRecpt3Fr());
			}
			
			if(setupParameterVO.getCutOffTimeForLinRecptTo()!=null)
			{
				lcParam.setCutOffTimeForLinRecptTo(setupParameterVO
					.getCutOffTimeForLinRecptTo());
			}
			
			if(setupParameterVO.getCutOffTimeForLinRecpt2To()!=null)
			{
			lcParam.setCutOffTimeForLinRecpt2To(setupParameterVO.getCutOffTimeForLinRecpt2To());
			}
			if(setupParameterVO.getCutOffTimeForLinRecpt3To()!=null)
			{			
			lcParam.setCutOffTimeForLinRecpt3To(setupParameterVO.getCutOffTimeForLinRecpt3To());
			}
			if(setupParameterVO.getCutOffTimeForLinenDelv()!=null)
			{
			lcParam.setCutOffTimeForLinenDelv(setupParameterVO.getCutOffTimeForLinenDelv());
			}
			
			if(setupParameterVO.getCutOffTimeForLinenDelv2()!=null){
			lcParam.setCutOffTimeForLinenDelv2(setupParameterVO
			.getCutOffTimeForLinenDelv2());}
			
					
			
				if(setupParameterVO.getCutOffTimeForLinenDelv3()!=null){
				lcParam.setCutOffTimeForLinenDelv3(setupParameterVO
						.getCutOffTimeForLinenDelv3());}
			 
			
			
			lcParam.setNoOfcutOfTimings(setupParameterVO.getNoOfcutOfTimings());
			lcParam.setCutOfDaysForLinenDelv(setupParameterVO.getCutOfDaysForLinenDelv());
			
			if(setupParameterVO.getCutOfDaysForLinenDelv2()!=null){
				lcParam.setCutOfDaysForLinenDelv2(setupParameterVO.getCutOfDaysForLinenDelv2());
				}
			if(setupParameterVO.getCutOfDaysForLinenDelv3()!=null){
				lcParam.setCutOfDaysForLinenDelv3(setupParameterVO.getCutOfDaysForLinenDelv3());
				}
			
			IBALogger.getLogger().debug(this.getClass(),"SetupParameterAssembler ---------end---------->convertVO2DO",null);
			return lcParam;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		if (!(oDO instanceof List)) {
			LcParamForFacility lcParam = (LcParamForFacility) oDO;
			SetupParameterVO setupParameterVO = new SetupParameterVO();
			
			String pattern="dd/MM/yyyy HH:mm";
			try {
				IBALogger.getLogger().debug(this.getClass(),"SetupParameterAssembler ------------------>convertDO2VO",null);
				if(lcParam.getDirtyLinenEntryByLaundry()!=null)
				{
				setupParameterVO.setDirtyLinenEntryByLaundry(lcParam
						.getDirtyLinenEntryByLaundry());
				}
				if(lcParam.getConfReqdForDirtyLinen()!=null)
				{
				setupParameterVO.setConfReqdForDirtyLinen(lcParam
						.getConfReqdForDirtyLinen());
				}
				if(lcParam.getStdStockChk()!=null)
				{
				setupParameterVO.setStdStockChk(lcParam.getStdStockChk());
				}
				setupParameterVO.setAddedById(lcParam.getAddedById());
				setupParameterVO.setAddedDate(lcParam.getAddedDate());
				setupParameterVO.setAddedAtWsNo(lcParam.getAddedAtWsNo());
				setupParameterVO.setAddedFacilityId(lcParam
						.getAddedFacilityId());
				setupParameterVO.setModifiedAtWsNo(lcParam.getModifiedAtWsNo());
				setupParameterVO.setModifiedById(lcParam.getModifiedById());
				setupParameterVO.setModifiedDate(lcParam.getModifiedDate());
				setupParameterVO.setModifiedFacilityId(lcParam
						.getModifiedFacilityId());
				setupParameterVO.setOperationFacilityid(lcParam
						.getOperatingFacilityId());
				if(lcParam.getCutOffTimeForLinenDelv()!=null)
				{
				IBADateTime dt1=new IBADateTime(lcParam.getCutOffTimeForLinenDelv());
				dt1.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinenDelv(dt1);
				}
				if(lcParam.getCutOffTimeForLinenDelv2()!=null)
				{
				IBADateTime dt2=new IBADateTime(lcParam.getCutOffTimeForLinenDelv2());
				dt2.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinenDelv2(dt2);
				}
				if(lcParam.getCutOffTimeForLinenDelv3()!=null)
				{
				IBADateTime dt3=new IBADateTime(lcParam.getCutOffTimeForLinenDelv3());
				dt3.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinenDelv3(dt3);
				}
				if(lcParam.getCutOffTimeForLinRecptFr()!=null)
				{
				IBADateTime dtF=new IBADateTime(lcParam.getCutOffTimeForLinRecptFr());
				dtF.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinRecptFr(dtF);
				}
				if(lcParam.getCutOffTimeForLinRecpt2Fr()!=null)
				{
				IBADateTime dtF2=new IBADateTime(lcParam.getCutOffTimeForLinRecpt2Fr());
				dtF2.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinRecpt2Fr(dtF2);
				}
				if(lcParam.getCutOffTimeForLinRecpt3Fr()!=null)
				{
				IBADateTime dtF3=new IBADateTime(lcParam.getCutOffTimeForLinRecpt3Fr());
				dtF3.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinRecpt3Fr(dtF3);
				}
				if(lcParam.getCutOffTimeForLinRecptTo()!=null)
				{
				IBADateTime dtT=new IBADateTime(lcParam.getCutOffTimeForLinRecptTo());
				dtT.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinRecptTo(dtT);
				}
				if(lcParam.getCutOffTimeForLinRecpt2To()!=null)
				{
				IBADateTime dtT2=new IBADateTime(lcParam.getCutOffTimeForLinRecpt2To());
				dtT2.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinRecpt2To(dtT2);
				}
				if(lcParam.getCutOffTimeForLinRecpt3To()!=null)
				{
				IBADateTime dtT3=new IBADateTime(lcParam.getCutOffTimeForLinRecpt3To());
				dtT3.setPattern(pattern);
				setupParameterVO.setCutOffTimeForLinRecpt3To(dtT3);
				}

				setupParameterVO.setNoOfcutOfTimings(lcParam.getNoOfcutOfTimings());
				if(lcParam.getCutOfDaysForLinenDelv()!=null)
				{
				setupParameterVO.setCutOfDaysForLinenDelv(lcParam.getCutOfDaysForLinenDelv());
				}
				if(lcParam.getCutOfDaysForLinenDelv2()!=null)
				{
				setupParameterVO.setCutOfDaysForLinenDelv2(lcParam.getCutOfDaysForLinenDelv2());
				}
				if(lcParam.getCutOfDaysForLinenDelv3()!=null)
				{
				setupParameterVO.setCutOfDaysForLinenDelv3(lcParam.getCutOfDaysForLinenDelv3());
				}
				IBALogger.getLogger().debug(
						this.getClass(),
						"SetupParameterAssembler -----End-convertDO2VO--->",
								 null);
			} catch (Exception e) {
				// TODO: handle exception
				IBALogger
						.getLogger()
						.debug(
								this.getClass(),
								"SetupParameterAssembler ---------EXCEPTION---------->convertDO2VO ",
								null);
				e.printStackTrace();
			}
			return setupParameterVO;
		} else
			return oDO;

	}
	// public LinenItemVO ConvertDataToVo(Object record[]) throws
	// AssemblerException {
	// IBALogger.getLogger()
	// .debug(
	// this.getClass(),
	// "SetupParameterAssembler ------------------>convertDATA2VO ",
	// null);
	// LinenItemVO linenItemVO = new LinenItemVO();
	// linenItemVO.setLinenItem((String) record[0]);
	// LinentypeVO linentypeVO=new LinentypeVO();
	// linentypeVO.setLinenTypeCode((String) record[1]);
	// linenItemVO.setLinenType(linentypeVO);
	//		
	// linenItemVO.setLongDesc((String) record[2]);
	// linenItemVO.setShortDesc((String) record[3]);
	//		
	// linenItemVO.setDisposable((String) record[4]);
	// return linenItemVO;
	// }

}
