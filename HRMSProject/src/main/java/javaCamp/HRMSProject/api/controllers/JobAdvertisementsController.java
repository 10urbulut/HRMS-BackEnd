package javaCamp.HRMSProject.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.HRMSProject.bussiness.abstracts.JobAdvertisementService;
import javaCamp.HRMSProject.core.utilities.results.DataResult;
import javaCamp.HRMSProject.core.utilities.results.Result;
import javaCamp.HRMSProject.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/JobAdvertisements")

public class JobAdvertisementsController {
 JobAdvertisementService jobAdvertisementService;

 	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
	super();
	this.jobAdvertisementService = jobAdvertisementService;
 	}

 	@CrossOrigin
			@GetMapping("/getByStatusTrue")
			public DataResult<List<JobAdvertisement>> getByStatus()
			{
				return this.jobAdvertisementService.getByStatus(true);
			}

			@CrossOrigin
				@PostMapping("/add")
				public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
					return this.jobAdvertisementService.add(jobAdvertisement);
							
				}
				
				@CrossOrigin
				@GetMapping("/findByStatusTrueOrderByPublicationDateDesc")
				  public DataResult<List<JobAdvertisement>> findByStatusOrderByPublicationDateAsc(){
					  
					  return this.jobAdvertisementService. findByStatusOrderByPublicationDateDesc(true);
				  }
				  
				  
				  
				@CrossOrigin
				@GetMapping("/ findByEmployer_CompanyNameAndStatus")
				 public    DataResult<List<JobAdvertisement>> findByEmployer_CompanyNameAndStatus(@RequestParam
				    		String companyName,boolean status ){
				    	
					 return this.jobAdvertisementService.findByEmployer_CompanyNameAndStatus(companyName, status);
					 
				    }
				@CrossOrigin
				@PostMapping("/update")
				public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
				
					return this.jobAdvertisementService.update(jobAdvertisement);
				}
				
				@CrossOrigin
				@PostMapping("/updatestatusPassive")
				public Result updateStatus(@RequestParam int id) {
					return this.jobAdvertisementService.updateStatus(id, false);
				}
}
