package com.bikeshare.ncs.dao;

import com.bikeshare.ncs.bean.BaseUserRole;
import com.bikeshare.ncs.bean.BaseUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    long countByExample(BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int deleteByExample(BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int insert(BaseUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int insertSelective(BaseUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    List<BaseUserRole> selectByExample(BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    BaseUserRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int updateByExampleSelective(@Param("record") BaseUserRole record, @Param("example") BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int updateByExample(@Param("record") BaseUserRole record, @Param("example") BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int updateByPrimaryKeySelective(BaseUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Sat Apr 18 21:43:16 CST 2020
     */
    int updateByPrimaryKey(BaseUserRole record);
}