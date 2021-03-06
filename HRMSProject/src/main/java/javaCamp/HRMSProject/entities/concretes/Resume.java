package javaCamp.HRMSProject.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="resumes")
@NoArgsConstructor
@AllArgsConstructor
public class Resume  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_id")
	private int resumeId;
	
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	
	
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List< JobInformation> jobInformations;
	
	
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<Image> images;
	
	
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<EducationInformation> educationInformations;
	
	
	@OneToMany(mappedBy = "resume")
	private List<KnownLanguage> knownLanguages;
	
	
	@OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
	private List<KnownTechnology> knownTechnologies;
		

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private JobSeeker jobSeeker;

	
}
