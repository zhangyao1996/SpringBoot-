package com.zhangyao.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 11:12:38 AM
*/
@NoRepositoryBean
public interface BaseRepository<T,I extends Serializable> extends PagingAndSortingRepository<T,I>,JpaSpecificationExecutor<T>{

}
