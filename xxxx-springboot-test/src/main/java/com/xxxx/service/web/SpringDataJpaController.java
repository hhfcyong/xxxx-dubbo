package com.xxxx.service.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxxx.service.Domain.Tree;
import com.xxxx.service.Domain.TreeRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/tree")
public class SpringDataJpaController {
	
	@Autowired
	TreeRepository treeRepository;
	
    @ApiOperation(value="获取Tree详细信息", notes="根据url的name来获取tree详细信息")
    @ApiImplicitParam(name = "name", value = "name值", required = true, dataType = "String",paramType="path")
	 @RequestMapping(value="/{name}",method=RequestMethod.GET)
	 public Tree findByName(@PathVariable String name){
		 return  treeRepository.findByName(name);
	 }
	 
	 @ApiOperation(value="创建书", notes="根据Tree对象创建树")
	 @ApiImplicitParam(name = "tree", value = "树实体Tree", required = true, dataType = "Tree")
	 @RequestMapping(value="/",method=RequestMethod.POST)
	 public String insertTree(@ModelAttribute Tree tree){
		 treeRepository.save(tree);
		 return "sucess";
	 }
	 @RequestMapping(value="/id/{id}",method=RequestMethod.GET)
	 public List<Tree> findByName(@PathVariable Integer id){
		 return treeRepository.findAll();
	 }
	 
	 /**
	  * 不加加参数分页
	  * @param page
	  * @param size
	  * @return
	  */
	 @ApiOperation(value="获取分页tree", notes="分页tree")
	  @ApiImplicitParams({
	   @ApiImplicitParam(name = "page", value = "page值", required = true, dataType = "Integer",paramType="path"),
	   @ApiImplicitParam(name = "size", value = "size值", required = true, dataType = "Integer",paramType="path")
	  })
	 @RequestMapping(value="/treepage/{page}/{size}",method=RequestMethod.GET)
	 public Page<Tree> findTree(@PathVariable Integer page,@PathVariable Integer size){
		 Pageable pageable=new PageRequest(page,size,Sort.Direction.ASC,"id");
		 return treeRepository.findAll(pageable);
	 }
	 /**
	  * 带参数分页
	  * @param page
	  * @param size
	  * @param name
	  * @return
	  */
	 @ApiOperation(value="带参数获取分页tree", notes="分页tree")
	  @ApiImplicitParams({
	   @ApiImplicitParam(name = "page", value = "page值", required = true, dataType = "Integer",paramType="path"),
	   @ApiImplicitParam(name = "size", value = "size值", required = true, dataType = "Integer",paramType="path"),
	   @ApiImplicitParam(name = "name", value = "name值", required = true, dataType = "String",paramType="path")
	  })
	 @RequestMapping(value="/treepage/{page}/{size}/{name}",method=RequestMethod.GET)
	 public List<Tree> findTree1(@PathVariable Integer page,@PathVariable Integer size,@PathVariable String name){
		 Pageable pageable=new PageRequest(page,size,Sort.Direction.ASC,"id");
		 Page<Tree> treePage=treeRepository.findAll(new Specification<Tree>(){

			@Override
			public Predicate toPredicate(Root<Tree> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				List<Predicate> list=new ArrayList<Predicate>();
				if(name!=null&&name!=""){
					list.add(arg2.equal(arg0.get("name").as(String.class), name));
				}
				Predicate[] p=new Predicate[list.size()];
				return arg2.and(list.toArray(p));
			}
			 
		 },pageable);
		 return treePage.getContent();
	 }
}
