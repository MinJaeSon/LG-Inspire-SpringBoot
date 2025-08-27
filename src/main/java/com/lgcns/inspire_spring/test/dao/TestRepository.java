package com.lgcns.inspire_spring.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lgcns.inspire_spring.test.domain.TestRequestDTO;
import com.lgcns.inspire_spring.test.domain.TestResponseDTO;

@Repository
public class TestRepository {
    
    @Autowired
    private TestMapper testMapper;
    
    /*
    SQL
    - JDBC(Java DataBase Connectivity)
    DB 연동 절차
    1. driver loading
    2. connection
    3. statement
    4. execute
    5. result set
    6. close
     */
    public TestResponseDTO selectRow(TestRequestDTO request) {
        System.out.println("[debug] >>> repository");
        String testSQL= "SELECT * " +
                        "FROM employee " +
                        "WHERE emp_id = "+request.getEmp_id()+
                        "AND emp_name = "+request.getEmail() ;
        System.out.println("[debug] >>> " + testSQL);

        TestResponseDTO response = TestResponseDTO.builder()
                                                .emp_id("100")
                                                .emp_name("한선기")
                                                .salary(900)
                                                .build();

        // System.out.println("[debug] >>> calling MyBatis mapper");
        // TestResponseDTO response = testMapper.selectRow(request);
        // System.out.println("[debug] >>> MyBatis result: " + response);

        return response;
    }
}
