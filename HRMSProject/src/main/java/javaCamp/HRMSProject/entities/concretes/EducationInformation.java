package javaCamp.HRMSProject.entities.concretes;

import java.sql.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="education_informations")

public class EducationInformation  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_information_id")
	private int educationInformationId;

	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="start_date_of_school")
	private Date startDateOfSchool;
	
	@Column(name="school_department")
	private String schoolDepartment;
	
	@Column(name="graduation_date")
	private Date graduationDate;
	
	@NotNull
	@Column(name="education_status")
	private boolean educationStatus;
	


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	private Resume resume;

}
