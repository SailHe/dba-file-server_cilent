package com.nit.demo.file;

/**
 * 与文件信息对应的JavaBean
 *
 * @author SN
 *
 */
public class FileBean {

	private Integer FId;
	private String FileName;

	public FileBean() {
	}

	public FileBean(Integer fId, String fileName) {
		super();
		FId = fId;
		FileName = fileName;
	}

	public Integer getFId() {
		return FId;
	}

	public void setFId(Integer fId) {
		FId = fId;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}
}
