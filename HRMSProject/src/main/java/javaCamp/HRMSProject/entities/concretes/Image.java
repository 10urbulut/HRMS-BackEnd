package javaCamp.HRMSProject.entities.concretes;





import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="images")
@EqualsAndHashCode(callSuper = false)

@AllArgsConstructor

@NoArgsConstructor
public class Image {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
    @Column(name="image_path")
	private String imagePath;
    
    @ManyToOne()
    @JoinColumn(name = "resume_id")
	private Resume resume;
    
    
}
