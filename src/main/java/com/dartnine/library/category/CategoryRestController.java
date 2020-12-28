package com.dartnine.library.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/category/api")
@ApiOperation(value="List category of the Library in a paginated way", response = List.class)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok: successfully listed"),
        @ApiResponse(code = 204, message = "No Content: no result founded"),
})
@Api(value = "Category Rest Controller: contains all operations for managing category")
public class CategoryRestController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/category")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<Category> categories = categoryService.findAll();
        if (categories != null) {
            List<CategoryDTO> categoriesDTO = categories.stream().map(category -> {
                return mapCategoryToCategoryDTO(category);
            }).collect(Collectors.toList());
            return new ResponseEntity<List<CategoryDTO>>(categoriesDTO, HttpStatus.OK);
        }
        return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/category/{code}")
    public ResponseEntity<CategoryDTO> getCategoryByCode(@PathVariable("code") String code){
        Category category = categoryService.getCategoryByCode(code);
        if (category != null) {
            CategoryDTO categoryDTO = mapCategoryToCategoryDTO(category);
            return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
        }
        return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
    }

    private CategoryDTO mapCategoryToCategoryDTO(Category category) {
        ModelMapper mapper = new ModelMapper();
        CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }
}
