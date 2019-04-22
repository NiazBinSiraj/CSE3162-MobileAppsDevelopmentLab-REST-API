package com.forget.simple;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forget.simple.models.bookInfo;
import com.forget.simple.Repository.bookInfoRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookInfo")

public class bookInfoController {
	
  @Autowired
  private bookInfoRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<bookInfo> getAllUsers() {
	  
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public bookInfo getUsertById(@PathVariable("id") ObjectId id) {
	  System.out.println(repository.findBy_id(id).getName());
      return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody bookInfo users) {
    users.set_id(id);
    repository.save(users);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public bookInfo createUser(@Valid @RequestBody bookInfo users) {
    users.set_id(ObjectId.get());
    repository.save(users);
    return users;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}