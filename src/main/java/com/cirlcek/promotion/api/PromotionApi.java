package com.cirlcek.promotion.api;

import com.cirlcek.promotion.entities.PromotionObject;
import com.cirlcek.promotion.entities.PromotionTest;
import com.cirlcek.promotion.service.LoginService;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/get-all")
@CrossOrigin
public class PromotionApi {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LoginService loginService;
//    @Autowired
//    private PromotionRepo promotionRepo;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllData(@RequestHeader("Authorization") String stringHeader) {
        try {
            HashMap<String,Object> response = new HashMap<>();
        System.out.println("Controller token param : " + stringHeader);
        if (stringHeader == null) {
            return new ResponseEntity<>("null", HttpStatus.BAD_REQUEST);
        }
        String checkToken = loginService.checkToken(stringHeader);
        System.out.println("Token isValid : " + checkToken);
        if (checkToken == null) {
            return new ResponseEntity<>("null", HttpStatus.BAD_REQUEST);
        }

        List<PromotionTest> promotionTests = jdbcTemplate.query("EXECUTE sp_SELECT_ALL_PROMOTION_FROM_TO_90DAY", BeanPropertyRowMapper.newInstance(PromotionTest.class));
        response.put("status",HttpStatus.OK);
        response.put("user",checkToken);
        response.put("promotion",promotionTests);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FOUND);
        }
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<Object> search(@RequestParam(name = "itemcode") String itemcode){
        try {
            if (itemcode == null){
                return new ResponseEntity<>("null",HttpStatus.FOUND);
            }
            System.out.println(itemcode);

           // SimpleJdbcCall simpleJdbcCall =

            List<PromotionTest> promotionSearch = jdbcTemplate.query("{ call   CK_PROMOTION_SEARCH(?) }",new Object[]{itemcode},BeanPropertyRowMapper.newInstance(PromotionTest.class));
            System.out.println(promotionSearch.size());
            return new ResponseEntity<>(promotionSearch,HttpStatus.OK);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FOUND);
        }
    }
}
