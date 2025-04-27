/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
			{"PATIENT_IS_NOT_DECEASED","APP-MO0001 病人未死亡"},
			{"PATIENT_ALREADY_REGISTERED","APP-MO0002 病人已注册"},
			{"MAX_SHOULD_BE_GT_NEXT","APP-MO0003 $ 应该大于 #"},
			{"MAX_SHOULD_BE_GT_START","APP-MO0004 最大数目应该大于开始数目"},
			{"START_NUM_CANT_BE_ZERO","APP-MO0005 开始编�?��?能为0"},
			{"CANT_BE_LT_DECEASED_DATE","APP-MO0006 机构收�?�/埋葬许�?��?之日�?能少于死亡日期"},
			{"PM_END_CANT_BE_LT_PM_START","APP-MO0007 死�?�结�?�日期/时间�?能少于开始日期/时间"},
			{"DATE_CANT_BE_LT_RECEIPT","APP-MO0008 日期�?能少于身体收�?�日期"},
			{"REG_NO_EXCEEDS_MAX_NO","APP-MO0009 注册�?�超过了�?�数设置的最大�?�"},
			{"AREA_EXCEEDS_CAPACITY","APP-MO0010 能力充满整个区域"},
			{"REGN_NO_CTRL_TO_BE_SETUP","APP-MO0011 控制�?�数登记�?�未设置"},
			{"SAME_PRACT_ID_NOT_ALLOWED","APP-MO0012 �?能选择�?�样的医生"},
			{"PARAMETER_TO_BE_SETUP","APP-MO0013 MO�?�数设置未定义"},
			{"CUTOFF_PERIOD_CHECK","APP-MO0014 �?于�?时数应该大于多于�?时数"},
			{"REGN_NOT_ALLOWED","APP-MO0015 �?�?许登记"},
			{"CANNOT_CREATE_BAYS","APP-MO0016 �?置已�?按区域能力建立"},
			{"BURIAL_PERMIT_NO_EXISTS","APP-MO0017 �?许埋葬�?�已�?存在"},
			{"BURIAL_PERMIT_NO_GT_ZERO","APP-MO0018 下一埋葬许�?��?�应该大于0或�?应该�?于下一埋葬许�?��?�"},
			{"DONOR_DETAILS_EXCEEDS_LIMIT","APP-MO0019 �??助者的详细资料�?能大于500个字符"},
			{"SAME_WITNESS","APP-MO0020 �?能有相�?�的�?�?"},
			{"SPECI_ANOTOM_UNIQUE","APP-MO0021 标本类型和Anotomical�?置应是唯一的"},
			{"POSTMORTEM_FINDINGS","APP-MO0022 死�?�的结果�?能大于500个字符"},
			{"CNT_ASIGN_SAME_DIAG_CODE","APP-MO0023 �?能分�?相�?�的诊断法"},
			{"PM_PURPOSE","APP-MO0024 �?作死�?�目的�?能超过250个字符？"},
			{"DEATH_CAUSE_EXCEEDS_LMT","APP-MO0025 死亡原因�?能超过250个字符"},
			{"POLICE_DET_EXCEEDS_LMT","APP-MO0026 警方细节�?能超过500个字符"},
			{"EXPRT_ADR_EXCEEDS_LMT","APP-MO0027 地�?��?能超过500个字符"},
			{"BURIAL_PERMIT_NOT_EXIST","APP-MO0028 埋葬许�?��?�?存在"},
			{"BURIAL_PERMIT_NOT_ALLOWED","APP-MO0029 埋葬许�?��?是�?�?许的，因为死�?�需�?"},
			{"OBTAINFROM_SELECT","APP-MO0030 �?�自�?��?必须选择"},
			{"REFRESH_INTERVAL_CHK","APP-MO0031 刷新间隔应在1至9999"},
			{"BLK_DATE_TIME","APP-MO0032 在此之�?被拒日期时间应大于系统日期时间"},
			{"VAC_BED_SEL","APP-MO0033选定的地点是目�?被分�?/�?�?"},
			{"BUR_NT_GEN","APP-MO0034 埋葬许�?��?尚未生�?.�?能继续...."},
			{"POLICE_DET_MAND","APP-MO0035 警方61个细节必须被抓获"},
			{"CAUSE_OF_DEATH_NOT_REC","APP-MO0036 死亡原因没有记录在案。无法进行。"},
			{"CNT_REASSIGN","APP-MO0037 订�?�已下.�?能订�?�一分�?区域."},
			{"CAPACITY_GREATER_LOCATION","APP-MO0038 能力值应大于创造的�?置"},
			{"CAPACITY_GREATER_ZERO","APP-MO0039 能力值应大于0"},
			{"DATE_CANT_BE_BLANK","APP-MO0040 日期�?能空白"},
			{"ENTER_BDYRCPT_DTTIME","APP-MO0041 机构收�?�日期/时间是必须首先输入"},
			{"ENTER_POLICE_DTLS","APP-MO0042 所有警察的细节必须输入"},
			{"FROM_DATE_LESS_EQ_TO_DATE","APP-MO0043 开始日期必须�?于等于终止日期"},
			{"REASON_CANT_MORE","APP-MO0044 原因�?能超过100个字符…"},
			{"BODY_PART_DTLS_CANT_VIEW","APP-MO0045 身体部分注册信�?��?能被在这里显现.."},
			{"ENTER_TISSUE_PROCMENT_DATE","APP-MO0046 组织采购日期必须输入"},
			{"CAPTURE_SPECIMEN_DTLS","APP-MO0047 所有标本的细节必须被抓获"},
			{"DATE_CANT_BE_LESS","APP-MO0048 $ 日期�?能�?于 # 日期"},
			{"CAPTURE_BURIAL_PRMT_DTLS","APP-MO0049 所有的埋葬许�?��?详细信�?�必须被�?�获"},
			{"SELECT_BODY_PART","APP-MO0050 必须选择一个器官"},
			{"CAPTURE_CONSENT_DTLS","APP-MO0051 所有的细节必须�?��?被�?�获"},
			{"CAPTURE_DONOR_DTLS","APP-MO0052 所有�??助者的详细资料必须被�?�获"},
			{"ENTER_DONOR_CARD_INFO","APP-MO0053 �??助�?�信�?�必须输入"},
			{"ID_MARKS_EXCEEDS_LMT","APP-MO0054 识别标志�?能超过500个字符…"}


	};
}			
