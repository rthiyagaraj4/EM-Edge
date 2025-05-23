/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"DUP_NAT_ID","APP-MP0001 相�?�的 #"},
		{"SELECT_RELN","APP-MP0002 如果病人的开始编�?�被输入，必须选择关系"},
		{"NAT_ID_NOT_BLANK","APP-MP0003 # 身份�?�?能为空白"},
		{"CANNOT_GREATER","APP-MP0004 # �?能大于 $"},
		{"CANNOT_LESSER","APP-MP0005 # �?能�?于 $"},
		{"LENGTH_100","APP-MP0006 #长度�?能超过100个字符"},
		{"NAT_ID_BLANK_EXT","APP-MP0007 # �?�为空白或者�?具备的外部�?��?"},
		{"NAT_ID_NO","APP-MP0008 # �?�能为数字"},
		{"NAT_ID_CHARS","APP-MP0009 # 必须为 @ 字符"},
		{"ALT_ID_NOT_BLANK","APP-MP0010 $ �?能为空白的�?�选�?件�?�"},
		{"ALT_ID_EXPIRED","APP-MP0011 $ 日期过期"},
		{"ALT_ID_EXP_WITH_GRACE","APP-MP0012 $ 日期是过期的，但它是在宽�?期"},
		{"ALT_ID_EXPIRED_CONFIRM","APP-MP0013 $ 日期是过期的，继续�?� ?"},
		{"ALT_ID_BLANK_EXT","APP-MP0014 $ �?�为空白或者�?具备的外部�?��?"},
		{"ALT_ID_CHARS","APP-MP0015 $ �?�必须为@ 字符"},
		{"RANGE_CHK_FOR_MIN","APP-MP0016 $ 必须大于MP�?�数中设置的的最�?值（＃）"},
		{"ALT_ID_NO","APP-MP0017 $ �?�能为数字"},
		{"RANGE_CHK_FOR_MAX","APP-MP0018 $ 必须�?于于MP�?�数中设置的的最大值（＃）"},
		{"ALT_ID_EXP_WITHIN","APP-MP0019 $ 将在。。。过期"},
		{"NOT_BLANK","APP-MP0020 % �?能为空"},
		{"ENTER_RELN","APP-MP0021 当设备�?�输入时，选择关系"},
		{"AGE_LESS_ZERO","APP-MP0022 年龄�?能低于零或负"},
		{"AGE_NOT_LESS_ZERO","APP-MP0023 年龄�?能低于零或负"},
		{"ALT_ID_10_CH","APP-MP0024 �?�选ID必须为10个字符"},
		{"ALT_ID_TYPE_NOT_BLANK","APP-MP0025 �?�选ID�?能为空"},
		{"APGAR_SCORE_NOT_GR_ZERO","APP-MP0026 Apgar评分�?能大于零"},
		{"INVALID_APGAR_SCORE","APP-MP0027 Apgar评分必须在1和10之间"},
		{"ONE_NAME_SELECT","APP-MP0028 至少选择一个�??称"},
		{"EM_BLNG_GRP_NOT_DEFINED","APP-MP0029 结算组紧急系列无法使用"},
		{"BIRTH_DATE_GREATER_SYSDATE","APP-MP0030 出生日期�?能大于系统日期"},
		{"BIRTH_TIME_GREATER_SYSTIME","APP-MP0031 出生时间�?能大于系统时间"},
		{"BT_WEIGHT_GR_ZERO","APP-MP0032 出生体�?必须大于0"},
		{"MR_SECTION_NOT_ALL_FAC","APP-MP0033 �?能为此设备定义MR部门"},
		{"ONLY_ONE_UNKNOWN_CAT","APP-MP0034 未知目录类型已存在"},
		{"CITIZENSHIP_NOT_BLANK","APP-MP0035 公民�?能空白"},
		{"CODE_NOT_BLANK","APP-MP0036 代�?�?能为空"},
		{"CODE_2_CH","APP-MP0037 代�?�?能�?于2个字符"},
		{"COML_LENGTH_100","APP-MP0038 并�?�症应�?超过100个字符"},
		{"CONT_MODE_NOT_BLANK","APP-MP0039 �?�系方�?�?能空白"},
		{"CNTRY_CODE_NOT_BLANK","APP-MP0040 国家代�?�?能空白"},
		{"CUTOFF_AGE_LE_MIN_AGE","APP-MP0041 截止年龄应�?于或等于最低年龄"},
		{"DOB_GREATER","APP-MP0042 出生日期�?能大于今天"},
		{"DOB_NOT_GR_TODAY","APP-MP0043出生日期�?能大于今天"},
		{"NB_DATE_INVALID","APP-MP0044 出生日期应大于�?亲？？年龄"},
		{"DAYS_GREATER_31","APP-MP0045 天�?能大于31"},
		{"DAYS_NOT_31_CH","APP-MP0046天�?能大于31"},
		{"DECEASED_DT_NOT_GR_TODAY","APP-MP0047 死亡的日期�?能大于当�?日期"},
		{"DECEASED_DATE_LESS_DOB","APP-MP0048 死亡的日期�?能少于出生日期"},
		{"CANNOT_LESS_ENC_DATE","APP-MP0049 死者的日期应大于或等于入院就诊日期"},
		{"DECEASED_REGN_DATE_CHK","APP-MP0050 死亡日期�?于病人注册时间/日期，继续�?�?"},
		{"EMER_SER_NOT_DEFINED","APP-MP0051 缺�?病人系列中没有在MP�?�数中定义"},
		{"DIFF_BET_TWO_DELY","APP-MP0052 之�?交付和当�?交付未作为MP�?�数设置，�?能继续"},
		{"CONFIRM_NAT_SERIES","APP-MP0053 你想改�?�病人国家编�?�系列?"},
		{"FILE_NO_REQD_YN","APP-MP0054 你想生�?文件?"},
		{"GEN_PAT_HIST_REP","APP-MP0055 你想生�?历�?�的病人详细报告?"},
		{"WANT_TO_PROCEED","APP-MP0056 继续�?�?"},
		{"DOC_ISS_DT_LESS_EXP_DT","APP-MP0057 文件签�?�日期应�?于到期日"},
		{"DUP_ALT_ID","APP-MP0058 �?�? $�?��?"},
		{"DUPL_LEGAL_NM_ORD","APP-MP0059 �?�?的法律�??称排�?"},
		{"DUPL_PAT_ID","APP-MP0060 �?�?病人编�?�"},
		{"EITHER_COPY_ORIGINAL","APP-MP0061 应选择原件或附年"},
		{"ENTER_PAT_NAT_ALT","APP-MP0062 应该输入病人编�?��?交替编�?�或国�?编�?�"},
		{"ERROR_GEN_FILE_NO","APP-MP0063 生�?文件�?�出错"},
		{"ERROR_GEN_PAT_ID","APP-MP0064 生�?病人编�?�出错"},
		{"EXP_DATE_GREATER","APP-MP0065 过期日期应该大于等于当�?日期"},
		{"FAM_ORDER_BLANK","APP-MP0066 姓的顺�?�?能为空"},
		{"FAM_PROMPT_BLANK","APP-MP0067 姓的�??示�?能为空"},
		{"FATHER_PATID_INVALID","APP-MP0068 父亲病历�?�无效"},
		{"FATHER_AGE_PARAM","APP-MP0069 父亲年龄应该大于在MP�?�数中设置的值"},
		{"PATID_SHOULD_BE_FEMALE","APP-MP0070 应该输入女病人编�?�"},
		{"FIELD1_SEC_BLANK","APP-MP0071 字段1�?能为空"},
		{"FIELD1_SIZE_BLANK","APP-MP0072 字段1大�?�?能为空"},
		{"FIELD2_SEC_BLANK","APP-MP0073 字段2�?能为空"},
		{"FIELD2_SIZE_BLANK","APP-MP0074 字段2大�?�?能为空"},
		{"FIELD3_SEC_BLANK","APP-MP0075 字段3�?能为空"},
		{"FIELD3_SIZE_BLANK","APP-MP0076 字段3大�?�?能为空"},
		{"FIELD4_SEC_BLANK","APP-MP0077 字段4�?能为空"},
		{"FIELD4_SIZE_BLANK","APP-MP0078 字段4大�?�?能为空"},
		{"FIELD5_SEC_BLANK","APP-MP0079 字段5�?能为空"},
		{"FIELD5_SIZE_BLANK","APP-MP0080 字段5大�?�?能为空"},
		{"FILE_NO_SUCCESS","APP-MP0081 文件% 已分�?"},
		{"FILE_NOT_APPL","APP-MP0082档案建立�?适用。无法进行"},
		{"FILE_ALREADY_CREATED_FT","APP-MP0083 档案已�?建立此文件类型"},
		{"FILE_NOT_FOR_FACILITY","APP-MP0084 文件没有建立这一设施"},
		{"FILE_TYPE_NOT_APPL","APP-MP0085 文件类型�?适用。无法建立档案。"},
		{"CANNOT_CREATE_FILE_TYPE","APP-MP0086 文件类型�?适用。无法建立。"},
		{"FINANCIAL_DET_MANDATORY","APP-MP0087 必须为病人输入财务细节"},
		{"FN_ORDER_BLANK","APP-MP0088 姓�?顺�?�?能空白"},
		{"FN_PROMPT_BLANK","APP-MP0089 姓�?�??示�?能空白"},
		{"VIEW_PAT_PHOTO_RESTRICT","APP-MP0090 对于责任 ~"},
		{"GEST_OUT_OF_RANGE","APP-MP0091 妊娠值应介于"},
		{"HEAD_PAT_SAME_AS_PAT","APP-MP0092 病人首编�?��?能和病人编�?�相�?�"},
		{"HEAD_PATIENT_NOT_ALLOWED","APP-MP0093 病人首编�?��?属于 ~"},
		{"HEAD_PATID_CHAR","APP-MP0094 病人首编�?�必须有@ 个字符"},
		{"HEAD_PAT_ID_10_CH","APP-MP0095 病人首编�?�必须有10个字符"},
		{"HEAD_PATID_BLANK","APP-MP0096 病人首编�?�为空白，选择关系"},
		{"PAT_FILE_IDX_FAIL","APP-MP0097 �?�入病人档案索引失败"},
		{"NO_INT_REQ_AVBL","APP-MP0098 内部请求报告的这一系列病人无法使用"},
		{"INVALID_NAT_ID","APP-MP0099 无效#"},
		{"INVALID_ALT_ID","APP-MP0100 无效$"},
		{"INVALID_APPT_REF_NO","APP-MP0101 无效的预约�?�考�?�"},
		{"NAT_ID_INVALID_DATE","APP-MP0102 无效的国家编�?�日期"},
		{"INVALID_EXP_DATE","APP-MP0103 无效的过期日期"},
		{"NAT_ID_INVALID_MONTH","APP-MP0104 无效的国家编�?�月"},
		{"INVALID_PAT_DRVN_LOGIC","APP-MP0105 无效的病人逻辑的推导"},
		{"INVALID_PATIENT","APP-MP0106 无效的病人编�?�"},
		{"INV_RANGE","APP-MP0107 无效范围"},
		{"ISSUE_DATE_GREATER","APP-MP0108 �?�行日期应�?于或等于当�?日期"},
		{"LV_END_DATE_GR_FROM_DATE","APP-MP0109 �?�期终止日期应该大于等于�?�期开始日期"},
		{"LEGAL_NM_1_4","APP-MP0110 法律�??称排�?应介于1和4"},
		{"MAX_LENGTH_30","APP-MP0111 长度�?能超过30个字符"},
		{"LENGTH_MIN_CHAR","APP-MP0112 长度应该为 @ 个字符"},
		{"LENGTH_10_CH","APP-MP0113 长度应该为10个字符"},
		{"LONG_DESC_NOT_BLANK","APP-MP0114 长的�??述�?能为空"},
		{"LONG_NAME_NOT_BLANK","APP-MP0115 长�??称�?能为空"},
		{"ORG_MEM_NOT_APP","APP-MP0116 维�?组织�?中�?适用于�?�选的唯一编�?"},
		{"GENDER_MISMATCH","APP-MP0117 男性病人编�?�应进入"},
		{"MIN_GRT_TO_MAX","APP-MP0118 最大年龄应大于或等于最低年龄"},
		{"CHEST_CIRCUM_RANGE_CHK","APP-MP0119 最大胸围应大于最�?胸围"},
		{"GESTATION_RANGE_CHK","APP-MP0120 最大妊娠应大于最�?妊娠"},
		{"HEAD_CIRCUM_RANGE_CHK","APP-MP0121 最大头围应大于最�?头围"},
		{"LENGTH_RANGE_CHK","APP-MP0122 最大长度应大于最�?长度"},
		{"MAX_3_FLDS_SECN","APP-MP0123 一个科�?许最多3个字段"},
		{"MAX_LEGAL_NM_ORD","APP-MP0124 最大订货法律�??称应当 %"},
		{"WEIGHT_RANGE_CHK","APP-MP0125 最大�?�?应大于最�?�?�?"},
		{"MEM_ID_SHLD_BE_BLANK","APP-MP0126 会员编�?�应该是空白的�?�组织会员"},
		{"MISMATCH_NAT_DOB","APP-MP0127 生日日期和 #�?匹�?"},
		{"MISMATCH_NAT_SEX","APP-MP0128 �?匹�?�?的性别与国家编�?�"},
		{"MONTH_GREATER_11","APP-MP0129 月�?能大于11"},
		{"MONTH_NOT_GR_11","APP-MP0130 月�?能大于11"},
		{"ONLY_ONE_SECT_FILE_CR","APP-MP0131 当�?�有�?�一文件被产生时，�?能建立超过三个段"},
		{"MOTHER_MAX_AGE","APP-MP0132 �?亲年龄�?能大于MP�?�数中指定的最大年龄"},
		{"MOTHER_CUTOFF_AGE","APP-MP0133 �?亲年龄低于MP�?�数中指定的年龄"},
		{"MOTHER_AGE_PARAM","APP-MP0134 �?亲年龄必须大于MP�?�数中指定的年龄"},
		{"MP_PARAM_NOT_FOUND","APP-MP0135 MP�?�数未定义"},
		{"SECT_CODE_BLANK","APP-MP0136 MR 段代�?为空白"},
		{"CHART_MAIN_MRN_PATID","APP-MP0137 MRN �?能和病人编�?�相�?�"},
		{"NAME_DRVN_BLANK","APP-MP0138 �??称推导逻辑�?能空白"},
		{"NAME_PFX_NOT_BLANK","APP-MP0139 �??称的�?缀�?能空白"},
		{"PREFIX_PROM_BLANK","APP-MP0140 �??称的�?缀�??示�?能空白"},
		{"NAME_SFX_NOT_BLANK","APP-MP0141 �??称�?�缀�?能空白"},
		{"SUFFIX_PROM_BLANK","APP-MP0142 �??称�?�缀�??示�?能空白"},
		{"NAT_ID_LEN_5_20","APP-MP0143 国�?编�?�长度应介于5和20"},
		{"NAT_ID_10_CH","APP-MP0144 国�?编�?�应该为10个字符"},
		{"NATIONALITY_CHANGED","APP-MP0145国�?已�?�?�更。检查财务细节"},
		{"NEWBORN_PARAM_NOT_DEFINED","APP-MP0146 新生儿结算�?�数没有确定。无法进行"},
		{"DUPLICATE_BIRTH_ORDER","APP-MP0147 新出生的，出生顺�?已�?存在"},
		{"REGN_RESTRICTED_FOR_NB","APP-MP0148 在MP�?�数指定的天数中，必须登记新生儿"},
		{"REGN_RSTRD_NB_HRS","APP-MP0149 在MP�?�数指定的�?时内，必须登记新生儿"},
		{"NO_MOTHER_BABY_LINKS","APP-MP0150 此孩�?记录�?�?�用于�?亲"},
		{"NO_FAMILY_MEMBERS","APP-MP0151 无病人的家庭�?员"},
		{"BIRTH_ORDER_VAL","APP-MP0152 出生�?�必须大于 1"},
		{"DIGITS_BLANK","APP-MP0153 数字�?��?能为空"},
		{"NO_PAT_REG_SESSION","APP-MP0154 本次会�?中无病人登记"},
		{"NOT_PATID_INVALID","APP-MP0155 通知病人编�?�无效"},
		{"NRIC_FOR_NONCITIZEN","APP-MP0156 $�?能输入�?�公民"},
		{"NRIC_CANNOT_BE_SAME","APP-MP0157 $ of # 必须和病人相�?� ~"},
		{"ALT_ID_NO_OF_DAYS_BLANK","APP-MP0158 在 $中的天数�?能为空"},
		{"OCPN_CLASS_NOT_BLANK","APP-MP0159 �?�业类型�?能空白"},
		{"NAT_ID_9_12","APP-MP0160 �?�有�?许数9至12个字符"},
		{"PAT_OR_REF_ALLOW","APP-MP0161 �?�有一个标准，�?�以指定�?�索"},
		{"ORDER_NOT_LESS_ZERO","APP-MP0162 顺�?�?��?能�?于或等于零"},
		{"ORDER_ALREADY_PRESENT","APP-MP0163 订�?�数�?已�?存在"},
		{"ORDER_NO_EXISTS","APP-MP0164 订�?�数�?已�?存在"},
		{"ORDER_BET","APP-MP0165 订�?�数�?必须在 $ 和 #之间"},
		{"ORDER_BETWEEN_1_7","APP-MP0166 订�?�范围必须在 1 和 7之间"},
		{"ORG_MEM_NOT_EXISTS","APP-MP0167 组织会员未作为病人设置。无法进行"},
		{"ORG_MOT_NOT_EXISTS","APP-MP0168 组织�?员没有出席�?亲？？？？"},
		{"OTH_LANG_LEGEND_NOT_DEFINED","APP-MP0169其他语言未定义，�?能继续"},
		{"OVERLAP_NOT_ALLOWED","APP-MP0170 �?�?许�?�?值"},
		{"PARAM_FCY_NOT_APPL","APP-MP0171 设施�?�数�?适用，�?能�?行"},
		{"PARITY_GR_GRAVIDA","APP-MP0172 �?�等�?能大于孕妇？？？"},
		{"MAX_PATIENT_AGE","APP-MP0173 病人年龄�?能超过"},
		{"PAT_DOB_NOT_CHANGE","APP-MP0174 病人出生日期�?应少于截止年龄，因为这病人生了一些婴儿"},
		{"APPT_REC_CHG","APP-MP0175 病人的数�?�已�?改�?�"},
		{"PAT_DRVN_1N_FN","APP-MP0176 病人的推导逻辑应首先为 1N 或 FN"},
		{"FILE_NOT_AVAIL_NO_PRINT","APP-MP0177 病人档案没有建立。�?能打�?�在线报告"},
		{"PAT_ID_NOT_FOUND_FOR_REF","APP-MP0178 病人编�?��?存在推�??"},
		{"PAT_ID_ALREADY_GEN","APP-MP0179 此记录已创建病人编�?�。无法进行"},
		{"PAT_ID_SERIES","APP-MP0180 此系列已输入病人编�?�"},
		{"PAT_ID_AVBL_APPT_REF_NO","APP-MP0181 病人编�?��?适用于预约�?�考�?�，�?能继续"},
		{"PATID_LEN","APP-MP0182 病人编�?�长度�?能为空白"},
		{"PAT_ID_LEN_5_20","APP-MP0183病人编�?�长度必须在5 到20之间"},
		{"ENTER_PAT_ID_SER_GRP","APP-MP0184 此系列必须输入病人编�?�"},
		{"PAT_ID_CH","APP-MP0185 病人编�?�应该在$字符内"},
		{"PAT_SER_PREFIX","APP-MP0186 病人编�?�必须为 $作为包�?��?缀"},
		{"PAT_ID_EXIST_IN_RANGE","APP-MP0187 病人编�?��?应该与现有的病人范围�?�?�"},
		{"BLACKLISTED_PATIENT","APP-MP0188 病人在黑�??�?�，�?能继续"},
		{"CANNOT_REC_DEATH_DTLS","APP-MP0189 患者目�?正在�?院/门诊，�?能记录死亡细节"},
		{"PATIENT_DECEASED","APP-MP0190 病人死亡，�?�?许更新"},
		{"PAT_DECEASED_NOT_ALLOWED","APP-MP0191 病人死亡，�?能继续"},
		{"PAT_INACTIVE_NOT_ALLOWED","APP-MP0192 患者是无效的..无法进行"},
		{"PAT_CAT_EXP","APP-MP0193 病人是没有资格作为�?务类的�?�系，有效期�?是空白或已过期"},
		{"LOC_NOT_ENTITLED","APP-MP0194 患者是无�?�对这项�?务的�?置"},
		{"PAT_ID_SUCCESS","APP-MP0195 病人�?功注册"},
		{"PAT_SUSPENDED_NOT_ALLOWED","APP-MP0196 病人已暂�?�..无法进行"},
		{"PAT_NM_DRVN_1N","APP-MP0197 病人姓�??推导逻辑的第一个�?��?必须 1N 或 FN"},
		{"PAT_NAME_NOT_ALLOWED","APP-MP0198 患者�??称设置�?是多部分。无法进行"},
		{"PAT_NUM_NOT_CREATED","APP-MP0199 病人编�?�未定义"},
		{"PATIENT_INACTIVE","APP-MP0200 病历是无效的。更新�?�?许"},
		{"INCOMPLETE_PAT_REC","APP-MP0201 病历是�?完整的。�?�系管�?�员�?"},
		{"PAT_UPD_SUCCESS","APP-MP0202 病历是�?功更新....."},
		{"PATIENT_SUSPENDED","APP-MP0203 病历是暂�?�。更新�?�?许"},
		{"PAT_SER_NOT_CREATED","APP-MP0204 患者系列未定义"},
		{"PAT_SEX_MISMATCH","APP-MP0205 患者性别与姓�??�?缀�?匹�?"},
		{"SEX_MIS_PREFIX","APP-MP0206 患者性别与姓�??�?缀�?匹�?"},
		{"PAT_SEX_NOT_CHANGE","APP-MP0207 病人生�?孩以�?�，性别�?能被更改"},
		{"POSTAL_CODE_NOT_BLANK","APP-MP0208 邮政编�?�?能空白"},
		{"PREF_FCY_NOT_LOG_FCY","APP-MP0209 推�??设备�?�?�于登录设备"},
		{"PURGE_DATE_UNTIL","APP-MP0210 清洗改�?��?能�?于等于清洗到达日期"},
		{"PURGE_DATE_GR_CURRENT","APP-MP0211 清洗日期�?能大于当�?日期"},
		{"PURGE_DATE_LESS_LAST","APP-MP0212 清洗日期�?能低于上次清洗日期"},
		{"CODE_ALREADY_EXISTS","APP-MP0213 记录已�?存在…"},
		{"RFRL_CODE_NOT_BLANK","APP-MP0214 推�??代�?�?能空白"},
		{"REFERRAL_REG_SUCCESS","APP-MP0215 带推�??�?�的推�??注册�?功完�?"},
		{"REL_MEM_EXISTS","APP-MP0216 相关�?员存在于组织�?员中，�?能继续."},
		{"RELGN_CODE_NOT_BLANK","APP-MP0217 宗教代�?�?能空白"},
		{"RES_STATUS_FOR_CITIZEN","APP-MP0218 居�?应该为公民或状�?应该为 # 公民法律"},
		{"SN_ORDER_BLANK","APP-MP0219 第二�??称顺�?�?能为空白"},
		{"SN_PROMPT_BLANK","APP-MP0220 第二�??称�??示�?能为空白"},
		{"VALID_AREA","APP-MP0221 选择有效区域"},
		{"VALID_OCN_CLASS","APP-MP0222 选择有效的�?�业分类"},
		{"VALID_REGION","APP-MP0223 选择一个有效的区域"},
		{"SHORT_DESC_NOT_BLANK","APP-MP0224 简短�??述�?能空白"},
		{"SHORT_NAME_NOT_BLANK","APP-MP0225 简称�?能空白"},
		{"SPL_CHAR_NOT_ALL_NMDRVN","APP-MP0226 �??称推导逻辑�?�?许特殊字符"},
		{"NAT_ID_SPL_NOT_ALLOWED","APP-MP0227 国家编�?�中�?�?许特殊字符"},
		{"SUBSEQUENT_DELY","APP-MP0228 ＭＰ�?�数中定义，�?�?�多出生登记应当在指定时间内"},
		{"PATIENT_SUSP_NOT_ALLOWED","APP-MP0229 暂�?��?务的病人是�?�?许的。�?�系管�?�员"},
		{"TERM_DIGIT_NOT_APPL","APP-MP0230 终端数字�?适用。无法进行"},
		{"TER_DIGIT1_BLANK","APP-MP0231 终端数字1的�?置�?能空白"},
		{"TER_DIGIT2_BLANK","APP-MP0232 终端数字２的�?置�?能空白"},
		{"TER_DIGIT3_BLANK","APP-MP0233 终端数字３的�?置�?能空白"},
		{"TER_DIGIT4_BLANK","APP-MP0234 终端数字４的�?置�?能空白"},
		{"TER_DIGIT5_BLANK","APP-MP0235 终端数字５的�?置�?能空白"},
		{"AGE_LIMIT_5_15","APP-MP0236 �?务年�?�?能为空"},
		{"ALT_ID_LEN_5_20","APP-MP0237 候补编�?�长度应介于5和20之间"},
		{"ENTER_LEGEND_NM","APP-MP0238 应该输入图例�??称"},
		{"TN_ORDER_BLANK","APP-MP0239 第三�??称顺�?�?能为空"},
		{"TN_PROMPT_BLANK","APP-MP0240 第三�??称�??示�?能为空"},
		{"DUP_ALTID_FOR_MEMBER","APP-MP0241 本组织�?员编�?�指定已�?与其他病人编�?�相�?�的组织"},
		{"PATIENT_MERGED_VALID","APP-MP0242 病人编�?�和#�?�并."},
		{"PAT_MERGED_VALID","APP-MP0243 这�??患者是�?�并＃，按查询继续"},
		{"BDCL_NOT_ENTITLED","APP-MP0244 此病人对�?务类的病床无使用�?�利"},
		{"SPL_NOT_ENTITLED","APP-MP0245 这�??病人是无�?�的�?务与此相关的�?置"},
		{"ALREADY_SUSP","APP-MP0246 记录已�?暂�?�"},
		{"SUSP_EARLIER","APP-MP0247 记录晚点暂�?�"},
		{"VALID_PAT_SER_GRP","APP-MP0248 未用的病人编�?�存在于选中的病人�?列中，�?能继续."},
		{"UPD_SECT_FAIL","APP-MP0249更新 MR 失败"},
		{"RANGE_CHK_FOR_MIN_MAX","APP-MP0250 有效值应该在 $ 和 @之间"},
		{"PATID_GREATER","APP-MP0251 值�?能大于等于病人编�?�长度."},
		{"VALUE_GREAT_ZERO","APP-MP0252 值必须大于0"},
		{"REGISTER_ONE_REFERRAL","APP-MP0253 至少有一个查询登记。"},
		{"REFERRAL_ID_NUM_NOT_DEFINED","APP-MP0254 未定义推�??�?��?"},
		{"ISSUED_LESS_CURR_DATE","APP-MP0255 �?�出日期必须�?于等于系统日期"},
		{"ISSUED_DATE_GR_EQ_LEAVE_FROM_DATE","APP-MP0256 �?�出日期应大于或等于休�?�开始日期"},
		{"MR_SECTION_NOT_DEFINED","APP-MP0257 MR 没有定义�?列"},
		{"LEN_OF_NAMES_CANNOT_EXCEED","APP-MP0258 �??字总长度�?能超过80个字符"},
		{"PATIENT_SEX_MISMATCH","APP-MP0259 病人姓�??和 $�?匹�?"},
		{"ONE_NAME_ENTER","APP-MP0260 至少输入一个�??字"},
		{"CANNOT_REVOKE_DEATH","APP-MP0261 病人标志为死亡，�?能注销死亡"},
		{"CANNOT_REVOKE_MOREG","APP-MP0262 殓房登记已完�?。�?能撤销死亡."},
		{"NO_IMAGE","APP-MP0263 未找到图�?."},
		{"MR_SECTION_SELECTED","APP-MP0264 必须选择MR科"},
		{"FUNCTION_NOT_APPL","APP-MP0265 功能�?适�?�，因为�?�替�?�的 ID1 规则�?适�?�"},
		{"VALID_NUMBERS","APP-MP0266 有效数字在2和3之间"},
		{"LENGTH_NOT_MATCH","APP-MP0267 关系水平长度和输入�?缀�?匹�?"},
		{"NON_ORGMEM_NOT_PAT_SER","APP-MP0268 �?�会员组织�?能被选择这个病人系列"},
		{"PAT_SER_CANNOT_BE_SAME","APP-MP0270 Patient Series Cannot be Same as Mother Series when Generate Patient ID is using Alternate ID1 Rule"},
		{"NON_FAMILY_NOT_PAT_SER","APP-MP0271 有关会员-�?�家庭�?能被选择这个病人系列"},
		{"REL_LEVEL_LENGTH","APP-MP0272 关系水平长度应该在3和4之间"},
		{"ALT_ID1_LENGTH","APP-MP0273 轮�?编�?1长度应该为 $"},
		{"ALT_ID1_NO_OF_DAYS_BLANK","APP-MP0274 替�?� ID1 编�?��?能为空白"},
		{"ALT_ID2_NO_OF_DAYS_BLANK","APP-MP0275 替�?� ID２ 编�?��?能为空白"},
		{"ALT_ID3_NO_OF_DAYS_BLANK","APP-MP0276 替�?� ID３ 编�?��?能为空白"},
		{"ALT_ID4_NO_OF_DAYS_BLANK","APP-MP0277 替�?� ID４编�?��?能为空白"},
		{"DUP_ALT_ID1","APP-MP0278 �?能选择相�?�的替�?�类型"},
		{"CHANGES_BANNER_CONTINUE","APP-MP0279 这一行动将�?��?更改。你�?继续�?�？"},
		{"DISP_VAL_NOT_GREATER_MAX_VAL","APP-MP0280 显示长度�?能大于最大长度"},
		{"FILE_ALREADY_CREATED_FS","APP-MP0281 在FS�?置，文件已建立"},
		{"DLA_PATIENT_EXISTS","APP-MPDLA 你想建一个新的DLA请求�?�?"},
		{"SQL_DB_CONN_FAIL","APP-MPDLA0283 �?能建立SQL SERVER数�?�库连接"},
		{"DLA_SEARCH_MANDATORY_CHK","APP-MPDLA0284 输入�??字或姓�?"},
		{"DLA_REQUEST_TIME_OUT","APP-MPDLA0285 请求超时"}



	};
}			
