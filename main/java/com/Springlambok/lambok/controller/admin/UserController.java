package com.Springlambok.lambok.controller.admin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Springlambok.lambok.dto.UserDTO;
import com.Springlambok.lambok.entity.User;
import com.Springlambok.lambok.mapper.UserMapper;
import com.Springlambok.lambok.repo.UserRepo;
import com.Springlambok.lambok.util.HashUtil;
import com.Springlambok.lambok.util.UploadFileUtils;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ServletContext app;

	@Autowired
	private UploadFileUtils uploadUtil;

	@Autowired
	private UserMapper mapper;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("")
	public String index(Model model) {
		String sortBy = request.getParameter("sort_by");
		String sortDirection = request.getParameter("sort_direction");
		String pageParam = request.getParameter("page");
		String limitParam = request.getParameter("limit");

		String sortField = sortBy == null ? "id" : sortBy;
		Sort sort = (sortDirection == null || sortDirection.equals("asc")) ? Sort.by(Direction.ASC, sortField)
				: Sort.by(Direction.DESC, sortField);
		int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
		int limit = limitParam == null ? 2 : Integer.parseInt(limitParam);

		Pageable pageable = PageRequest.of(page, limit, sort);
		Page pageData = userRepo.findAll(pageable);

		model.addAttribute("pageData", pageData);
		return "admin/user/index";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(value = "id") User entity, Model model) {

		UserDTO userDto = mapper.converToDto(entity);

		model.addAttribute("userdto", userDto);

		return "admin/user/edit";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("uploadfile") MultipartFile uploadFile) {
		this.uploadUtil.handelUploadFile(uploadFile);

		return "redirect:/";
	}
	// optional

	@GetMapping("/show/{id}")
	public String show(@PathVariable(value = "id") User entity, Model model) {

//		dung voi path int id User user = userRepo.getOne(id);

		UserDTO userDto = mapper.converToDto(entity);
		System.out.println(userDto.getUsername());

		return "admin/user/index";
	}

	@GetMapping("/create")
	public String add() {
		return "admin/user/add";
	}

	@PostMapping("/store")

	public String store(Model model, @Valid UserDTO dto, BindingResult rs) {
		if (rs.hasErrors()) {
			System.out.println("co loi xay ra, trong luc tao moi");
			return "admin/user/add";
		} else {
			User entity = mapper.convertToEntity(dto);
			String hashedPass= HashUtil.hash(entity.getPassword());
			entity.setPassword(hashedPass);
			userRepo.save(entity);
			System.out.println("KHong co loi va TAo moi thanh cong");
			return "redirect:/users";
		}

	}

	// restApi
//	@PostMapping("")
	@PostMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("userdto") UserDTO userDTO, BindingResult rs, Model model) {
   //dung binding result thi khi redirect ta se mac dinh se su dung dc
		//form errror
		if (rs.hasErrors()) {
			System.out.println("co loi xay ra, trong luc cap nhat");

			return "admin/user/edit";
		} else {
			User entity = mapper.convertToEntity(userDTO);
			userRepo.save(entity);
			System.out.println("KHong co loi va cap nhat thanh cong");
			return "redirect:/users";
		}

	}

	// restApi
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

		System.out.println("vao day xoa");
		userRepo.deleteById(id);
		return "redirect:/users";
	}
}
