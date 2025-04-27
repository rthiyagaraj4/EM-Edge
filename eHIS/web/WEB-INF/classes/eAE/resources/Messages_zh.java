/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }



	static final Object[][] contents = {
			{"AE_VISIT_REG_COMPLETE","APP-AE0001病人就诊完�?"},
			{"NO_OF_HRS_1_T0_23","APP-AE0002 �?时范围必须在1～23之间"},
			{"MAX_DAYS_FOR_REV_VISIT","APP-AE0003最高�?�以修改就诊的天数必须大于等于1"},
			{"GYNAE_AGE_LIMIT","APP-AE0004 �?�获gynaec明细的最�?年龄应该超过12"},
			{"PAEDIATRIC_MAX_AGE","APP-AE0005 儿科最大年龄必于�?于15�?"},
			{"CUT_OFF_MAX_HRS","APP-AE0006 包括�?一天的就诊截止期应该�?超过去12"},
			{"AE_INVALID_ENCOUNTER_ID","APP-AE0007 �?�法的 Encounter ID"},
			{"AE_INVALID_MRN","APP-AE0008 �?�法文件�?�"},
			{"AE_PAT_MRN_ENC_BLANK","APP-AE0009 指定任一个病人编�?��?文件编�?��? Encounter ID标准"},
			{"AE_BLANK_LOCATION","APP-AE0010 �?置�?能空白"},
			{"AE_VISIT_PARAM_DATE_TIME","APP-AE0011 就诊时间应该大于急诊�?�数设置的日期时间并�?于系统时间"},
			{"AE_ALREADY_VISIT_LOCN","APP-AE0012 病人已�?到就诊�?置"},
			{"AE_TRIAGE_START_DATE_TIME","APP-AE0013 开始时间必须大于就诊时间并�?于系统时间"},
			{"AE_TRIAGE_END_DATE_TIME","APP-AE0014 结�?�时间必须大于开始时间并�?于系统时间"},
			{"AE_VISIT_REG_INCOMPLETE","APP-AE0015 就诊未完�?"},
			{"AE_MULTI_OPER_STN_FOR_USER","APP-AE0016 �?许多个工作站，�?能�?作�?"},
			{"AE_NO_CLINICS_FOR_USER","APP-AE0017 没有定义工作站的�?置"},
			{"AE_NO_OPER_STN_FOR_USER","APP-AE0018 没有定义用户的工作站"},
			{"AE_MANAGEQ_NOT_ALL_OPERSTN","APP-AE0019 工作站�?�?许管�?�病人队列"},
			{"CHECKOUT_NOT_ALL_OPERSTN","APP-AE0020 工作站�?�?许病人出区"},
			{"AE_REG_ATTN_NOT_ALL_OPERSTN","APP-AE0021 �?�?许工作站注册出席情况"},
			{"AE_SUSPENDED_NOT_ALLOWED","APP-AE0022 病人暂�?�，�?能�?作"},
			{"AE_DECEASED_NOT_ALLOWED","APP-AE0023 病人死亡。。。无法进行"},
			{"AE_REVISIT_NOT_ALL_OPERSTN","APP-AE0024 工作站�?�?许修改就诊"},
			{"AE_TMT_AREA_BLANK","APP-AE0025 治疗区域�?能为空"},
			{"AE_LOCATION_BLANK","APP-AE0026 �?置�?能为空"},
			{"AE_PRACTITIONER_BLANK","APP-AE0027 医生�?能为空"},
			{"AE_VISIT_DATE_TIME_CK1","APP-AE0028 就诊时间必须大于急诊�?�数�?病人登记时间"},
			{"AE_VISIT_DATE_TIME_CK2","APP-AE0029就诊时间必须�?于系统时间"},
			{"AE_PARAM_NOT_FOUND","APP-AE0030 装置未设置 AE�?�数"},
			{"AE_INACTIVE_PATIENT","APP-AE0031 病人没有激活"},
			{"AE_NUR_PHY_BLANK","APP-AE0032医生或护士是强制输入的"},
			{"AE_NO_LOC_FOR_SEL_AGE_SEX","APP-AE0033没有选择病人性别/年龄的地方"},
			{"AE_LMP_DATE_CHECK","APP-AE0034 LMP日期�?能大于系统日期"},
			{"AE_ANY_ONE_NEEDED","APP-AE0035 必须输入任一个评估明细"},
			{"AE_EXAM_DATE_TIME_C1","APP-AE0036 检查时间必须大于等于分�?治疗的时间"},
			{"AE_EXAM_DATE_TIME_C2","APP-AE0037 检查时间必须�?于等于系统时间"},
			{"AE_ASSIGN_DATE_TIME_C1","APP-AE0038 时间必须大于等于就诊时间"},
			{"AE_ASSIGN_DATE_TIME_C2","APP-AE0039 时间必须�?于等于系统时间"},
			{"AE_ASSESSMENT_DATE_TIME_C2","APP-AE0040 评估日期必须�?于等于系统日期"},
			{"AE_ASSESSMENT_DATE_TIME_C1","APP-AE0041 评估日期必须大于等于分�?的治疗区域的日期时间"},
			{"AE_NUMBER_ZERO","APP-AE0042 数�?必须大于0"},
			{"AE_EMER_DEAD_PATIENT","APP-AE0043 急诊死亡患者�?能输入A & E细节"},
			{"AE_ASSIGN_TMT_AREA","APP-AE0044 想分�?床�?�?治疗区域�?�？"},
			{"PAT_DECEASED_CONTINUE","APP-AE0045 病人死亡…继续�?�?"},
			{"PAT_SUSPENDED_CONTINUE","APP-AE0046 病人被�?定……继续�?作�?�？"},
			{"PAT_INACTIVATED_CONTINUE","APP-AE0047 病人未被激活…继续�?�?"},
			{"VACC_DATE_LE_CURRDATE","APP-AE0048 疫苗接�?日期应�?于或等于当�?日期"},
			{"DIAG_NOT_REC_CHKOUT_NOT_ALLWD","APP-AE0049 诊断未录入，病人�?能出区"},
			{"OPEN_VST_STATUS_FOR_AE_CLINIC","APP-AE0050 病人已�?在就诊，�?能继续"},
			{"REV_DATE_LESS_AE_PARAM","APP-AE0051 �?能修改�?于AE�?�数中指定的天数的患者的就诊细节，"},
			{"NOTES_NOT_REC_CHKOUT_NOT_ALLWD","APP-AE0052 备注未输入，病人�?能出区"},
			{"ANY_ONE_VALUE_ENTERED","APP-AE0053 病人字�?��?年龄至少必须输入一个"},
			{"DATE_NOT_LESS_THIRY_ONE","APP-AE0054 天数必须�?于等于30"},
			{"SPARE_BAY_CANT_BE_ASGNED","APP-AE0055 特殊床�?�?能作为一个正常的空闲床�?分�?"},
			{"SELECT_ONE_PATIENT_ID","APP-AE0056 �?�一时间�?�能选择一个病人"},
			{"PREG_DATE_GT_DOB","APP-AE0057 怀孕日期应该大于出生日期？"},
			{"NOT_UNKNOWN_PATIENT","APP-AE0058 �?能选择或输入一个未知的注册病人"},
			{"NOT_KNOWN_PATIENT","APP-AE0059 �?能选择或输入一个未知的注册病人"},
			{"PROCESS_SUBMITTED","APP-AE0060 进程已�?作为一个任务�??交"},
			{"LMP_DATE_GT_DOB","APP-AE0061 LMP 日期必须大于出生日期"},
			{"START_DT_LE_CURR_DT","APP-AE0062 开始时间必须�?于等于当�?时间"},
			{"REFRESH_INTVL_CHK","APP-AE0063 刷新间隔应在5至9999之间"},
			{"AE_CHECKED_OUT","APP-AE0064 病人已出区"},
			{"AE_PAT_ENC_BLANK","APP-AE0065 指定任�?一个病人编�?� / Encounter ID标准"},
			{"BED_OCCUPIED","APP-AE0066 床�?已�?被其他病人�?�用"},
			{"INVALID_BED","APP-AE0067 �?�法床�?"},
			{"BED_RESERVED","APP-AE0068 床�?已�?留"},
			{"RES_UNTIL_LESS_SYSDATE","APP-AE0069 �?留时间必须�?于等于系统时间"},
			{"PRACT_IS_NOT_WORKING","APP-AE0070 医生当日休�?�"},
			{"SCORE_CANNOT_REPE","APP-AE0071 $ 分数�?能�?述？？？"},
			{"PAT_ID_ENC_ID_GENERATED","APP-AE0072 生�?的病人字员从 ! 到 @ ， Encounter ID从 # 到 $"},
			{"PAT_ID_GENERATED","APP-AE0073 生�?的病人字�?�从! 到 @"},
			{"NO_BED_FOR_CRITERIA","APP-AE0074床�?�?适用于特殊标准"},
			{"BED_RESERVN_FAILED","APP-AE0075 �?留床�?失败"},
			{"CANT_ASSIGN_TRMT_AREA","APP-AE0076 �?能为病人分�?治疗区域"},
			{"ATTEND_DATE_GT_CURR","APP-AE0077 出席日期 $必须大于当�?日期"},
			{"DATE_GT_CURR","APP-AE0078 日期 $�?应该大于当�?日期."},
			{"DISPOSI_DATE_GT_CURR","APP-AE0079 $ 日期�?应该大于当�?日期"},
			{"DECEASE_DATE_GT_CURR","APP-AE0080 死亡日期$应该大于当�?日期."},
			{"ASSIGN_BED_YN","APP-AE0081 床�?� $分�?给病人?"},
			{"PATSEEN_DATE_GT_CURR","APP-AE0082 $ 病人回顾日期�?能大于当�?日期"},
			{"PREG_DT_GT_SYSDATE_AND_DOB","APP-AE0083 怀孕的日期�?应当大于系统日期，�?应�?于出生日期"},
			{"VISIT_DATE_GT_CURR","APP-AE0084 就诊日期 $�?应该大于当�?日期"},
			{"AE_DISASTER_LIMIT","APP-AE0085 在�?�一时间，病人总数�?能超过50,如果有更多病人需�?登记，就�?新�?作。"},
			{"CHG_FIN_DTLS_AE","APP-AE0086 区域�?登记类型�?就诊日期已必�?�，请�?次检查费用情况"},
			{"REG_ATTEN_NOT_ALLOWED_FOR_CURR_INPAT","APP-AE0087 当�?�?院病人�?能登记门诊？"},
			{"NO_AE_USER_RIGHTS","APP-AE0088 用户无�?��?…�?能�?作"}

		

	};
}			
