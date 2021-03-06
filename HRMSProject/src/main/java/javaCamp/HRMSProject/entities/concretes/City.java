package javaCamp.HRMSProject.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@Data
@Entity
@Table(name="cities")
@NoArgsConstructor
@AllArgsConstructor


public class City {
	
	
	@Id
	@Column(name="city_id")
	private int id;
	
	@Column(name="city_name")
	private String cityName;

	@OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
	private List<JobAdvertisement> jobAdvertisements;
}
