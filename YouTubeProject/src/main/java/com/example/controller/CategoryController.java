package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.enums.ProfileRole;
import com.example.service.CategoryService;
import com.example.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping({"/private"})
    public ResponseEntity<Integer> create(@RequestBody CategoryDto dto,
                                          HttpServletRequest request) {
        JwtUtil.checkForRequiredRole(request, ProfileRole.ADMIN);
        Integer prtId = (Integer) request.getAttribute("id");
        return ResponseEntity.ok(categoryService.create(dto, prtId));
    }
    @PutMapping("/private/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") Integer id,
                                          @RequestBody CategoryDto categoryDto,
                                          HttpServletRequest request) {
        JwtUtil.checkForRequiredRole(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(categoryService.update(id, categoryDto));
    }

    @DeleteMapping("/private/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable ("id") Integer id,
                                              HttpServletRequest request) {
        JwtUtil.checkForRequiredRole(request, ProfileRole.ADMIN);
        return ResponseEntity.ok(categoryService.deleteById(id));
    }

    @GetMapping("/list-paging")
    public ResponseEntity<Page<CategoryDto>> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                                  @RequestParam(value = "size", defaultValue = "2") int size) {
        return ResponseEntity.ok(categoryService.getAll(page, size));
    }
}
