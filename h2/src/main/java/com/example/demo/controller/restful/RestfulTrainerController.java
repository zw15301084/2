package com.example.demo.controller.restful;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.secondary.Trainer;
import com.example.demo.service.secondary.TrainerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/trainer")
@Api(value="onlineTrainerManage", description="Operations trainer infomation in Online Store")
public class RestfulTrainerController {
	
	@Autowired
    TrainerService TrainerService;
	
	@ApiOperation(value = "View a list of available trainers",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The Info you were trying to reach is not found")
    }
    )
	
	@RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public ResponseEntity<Iterable<Trainer>> list(Model model){
		Iterable<Trainer> Trainerlist = TrainerService.getAllTrainer();
		//http缓存
		CacheControl cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES);
		return ResponseEntity.ok()
		           .cacheControl(cacheControl)
		           .body(Trainerlist);
    }
	
	@ApiOperation(value = "Search a trainer with an ID",response = Trainer.class)
	@PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
	@RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Trainer> showProduct(@PathVariable Integer id, Model model){
		Trainer trainer = TrainerService.getById(id);
		//http缓存
		CacheControl cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES);
		return ResponseEntity.ok()
		           .cacheControl(cacheControl)
		           .body(trainer);
    }
	
	@ApiOperation(value = "Add a trainer")
	@PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> saveProduct(@RequestBody Trainer trainer){
		System.out.println("delete a trainer id:"+trainer.toString());
		//TrainerService.save(trainer);
        return new ResponseEntity<Object>("Product saved successfully", HttpStatus.OK);
    }
	
	@ApiOperation(value = "Update a trainer info")
	@PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer id, @RequestBody Trainer Trainer){
	 	Trainer storedTrainer = TrainerService.getById(id);
	 	storedTrainer.setAddress(Trainer.getAddress());
	 	storedTrainer.setMobileNum(Trainer.getMobileNum());
	 	storedTrainer.setMotto(Trainer.getMotto());
	 	storedTrainer.setSpecialties(Trainer.getSpecialties());
	 	storedTrainer.setUsername(Trainer.getUsername());
	 	System.out.println("update a trainer id:"+id);
	 	//TrainerService.save(Trainer);
        return new ResponseEntity<Object>("Product updated successfully", HttpStatus.OK);
    }
	
	@ApiOperation(value = "Delete a trainer info")
	@PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
    	//TrainerService.delete(id);
		System.out.println("delete a trainer id:"+id);
        return new ResponseEntity<Object>("Product deleted successfully", HttpStatus.OK);

    }
	
}
