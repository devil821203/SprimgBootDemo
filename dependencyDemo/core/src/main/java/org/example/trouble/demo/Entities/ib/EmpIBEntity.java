package org.example.trouble.demo.Entities.ib;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 行員檔
 */
@Data
@Entity
@Table(schema = "BIZ", name = "EMPIB")
@NoArgsConstructor
public class EmpIBEntity {
    
    /** 行員代號 */
	@Id
	private String empId;

	/** ID */
	@Basic
	private String empUid;

	/** 行員名稱 */
	@Basic
	private String empName;

	/** 所屬分行代號 */
	@Basic
	private String empBrNo;

	/** 所屬部室代號 */
	@Basic
	private String empDeptNo;

	/** 新增更新日期 */
	@Basic
	private Date updateDate;

	/** 新增更新人員 */
	@Basic
	private String updateUser;
}
