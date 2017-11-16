package com.karma.gema.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alejandro Tarazona
 *
 */

@Entity
@Table(name = "certificate")
public class Certificate extends BaseEntity {

	private Long id;
	private String filename;
	private File file;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "name")
	public String getFilename() {
		return filename;
	}

	@Column(name = "file")
	public File getFile() {
		return file;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
