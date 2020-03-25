package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentDaoJdbcMockTest {

    @InjectMocks
    private DepartmentDaoJdbc departmentDao;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<RowMapper<Department>> mapper;

    @AfterEach
    void after() {
        verifyNoMoreInteractions(namedParameterJdbcTemplate);
    }

    @Test
    public void getDepartments() throws SQLException {

        int id = 5;
        String name = "name";
        Department department = new Department();
        ResultSet rs = mock(ResultSet.class);
        String sql = "select";
        ReflectionTestUtils.setField(departmentDao, "selectSql", sql);

        when(namedParameterJdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(Collections.singletonList(department));
        when(rs.getInt(anyString())).thenReturn(id);
        when(rs.getString(anyString())).thenReturn(name);

        List<Department> departments = departmentDao.findAll();
        assertNotNull(departments);
        assertEquals(1, departments.size());
        Department dep = departments.get(0);
        assertNotNull(dep);
        assertSame(dep, department);

        verify(namedParameterJdbcTemplate).query(eq(sql), mapper.capture());

        RowMapper<Department> rowMapper = mapper.getValue();
        assertNotNull(rowMapper);
        Department result = rowMapper.mapRow(rs, 0);
        assertNotNull(result);
        assertEquals(id, result.getDepartmentId().intValue());
        assertEquals(name, result.getDepartmentName());
    }

}