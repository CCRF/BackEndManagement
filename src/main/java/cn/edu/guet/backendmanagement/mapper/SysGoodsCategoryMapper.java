package cn.edu.guet.backendmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HHS
 * @date 2022/08/12 15:03
 */
@Mapper
public interface SysGoodsCategoryMapper {
    boolean insertGC(@Param(value = "id") String id, @Param(value = "id") String gid, @Param(value = "type") String type);
    boolean updateGCByGId(@Param(value = "gid") long gid, @Param(value = "cid") long type);
    boolean deleteGCByGId(long id);
    boolean deleteGCByCId(long id);
}
