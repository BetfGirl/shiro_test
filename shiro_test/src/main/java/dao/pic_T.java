package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import model.pic;
@Repository
public interface pic_T {
	@Insert("insert into pic (adree) values(#{where})")
	public void insert(@Param("adree") String adree);

}
